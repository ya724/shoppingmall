package com.micro.controller;

import com.micro.api.UserServiceClient;
import com.micro.pojo.User;
import com.micro.utils.MessageUtils;
import com.micro.utils.ResultCode;
import com.micro.utils.ResultCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-19 15:42
 * @Description: TODO
 */
@Controller
@Slf4j
public class UserController {

    @Autowired
    UserServiceClient userServiceClient;

    @Value("${app.APIID}")
    String APIID;

    @Value("${app.APIKEY}")
    String APIKEY;

    /**
     * 用户新增
     * @param user
     * @return
     */
    @PostMapping("/user_add")
    @ResponseBody
    public ResultCommon user_add(User user, HttpSession session,String user_message) {
        System.out.println("调用端:"+user);
        String system_message=(String) session.getAttribute("system_message");
        if(system_message.equals(user_message)){
            Integer count = userServiceClient.add(user);
            if (count > 0) {
                return ResultCommon.success(ResultCode.SUCCESS);
            }else {
                return ResultCommon.success(ResultCode.FAIL);
            }
        }else{
            return ResultCommon.success(ResultCode.CODE_FAIL);
        }
    }

    /**
     * 短信发送
     * @param phonenumber
     * @return
     */
    @PostMapping("/user_sendmessage")
    @ResponseBody
    public ResultCommon user_sendmessage(String phonenumber, HttpSession session){
        String message = MessageUtils.sendMessage(phonenumber, APIID, APIKEY);
        if(message!=null){
            log.info("系统生成的验证码是："+message);
            session.setAttribute("system_message",message);
            return ResultCommon.success(ResultCode.SUCCESS);
        }else{
            return ResultCommon.success(ResultCode.FAIL);
        }
    }

}
