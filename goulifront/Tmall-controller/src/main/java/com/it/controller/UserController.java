package com.it.controller;

import com.it.bean.User;
import com.it.service.UserBuyProductVoService;
import com.it.service.UserService;
import com.it.utils.PageUtil;
import com.it.utils.ResultCode;
import com.it.utils.ResultCommon;
import com.it.vo.UserBuyProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @Resource
    UserBuyProductVoService userBuyProductVoService;

    @ResponseBody
    @RequestMapping("/user_login")
    public ResultCommon UserLogin(User user,String  code,HttpSession session){
        User user1 = userService.UserLogin(user);
        String usercode = (String) session.getAttribute("code");

        if(usercode.equals(code)){

            if (user1!=null){
                session.setAttribute("loginUser",user1);
                return ResultCommon.success(ResultCode.SUCCESS);
            }
            else {
                return ResultCommon.fail(ResultCode.LOGIN_FAIL);
            }
        }else {
            return ResultCommon.fail(ResultCode.CODE_FAIL);
        }

    }

    @RequestMapping("/user_page")
    public String userManagePage(@RequestParam(value = "user_nickname", defaultValue = "") String user_nickname,
                                @RequestParam(value = "user_gender", defaultValue = "-1") String user_gender,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("user_nickname",user_nickname);
        map.put("user_gender",user_gender);
        Integer allCount = userService.GetAllCount(map);
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> users = userService.GetPageUsers(map);

        PageUtil pageUtil=new PageUtil(pageIndex,pageSize,allCount,users);

        model.addAttribute("user_nickname",user_nickname);
        model.addAttribute("user_gender",user_gender);
        model.addAttribute("pageUtil",pageUtil);
        return "userManagePage";
    }

    @RequestMapping("/user_info/{user_id}")
    public String GetUserInfo(@PathVariable("user_id") Integer user_id,Model model){
        User user = userService.GetUserById(user_id);
        List<String> userAddress = userService.GetUserAddress(user.getUser_address());
        StringBuffer sb=new StringBuffer();
        for (String address:userAddress) {
            sb.append(address).append("  ");
        }
        List<UserBuyProductVo> userBuyProductVos = userBuyProductVoService.GetUserBuyProductVoById(user_id);

        for (UserBuyProductVo userbuyproduct:userBuyProductVos) {
            String productImage = userBuyProductVoService.GetProductImage(userbuyproduct.getProduct_id());
            userbuyproduct.setProductimage_src(productImage);
        }

        String userHomeplace = userService.GetUserHomeplace(user.getUser_homeplace());
        model.addAttribute("user",user);
        model.addAttribute("userAddress",sb.toString());
        model.addAttribute("userHomeplace",userHomeplace);
        model.addAttribute("userBuyProductVo",userBuyProductVos);
        return "userDetailsPage";
    }


}
