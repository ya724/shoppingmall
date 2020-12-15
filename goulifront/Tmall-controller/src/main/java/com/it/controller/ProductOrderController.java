package com.it.controller;

import com.it.bean.ProductOrder;
import com.it.bean.User;
import com.it.mapper.UserBuyProductVoMapper;
import com.it.service.ProductOrderService;
import com.it.service.UserService;
import com.it.utils.PageUtil;
import com.it.vo.UserBuyProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductOrderController {

    @Resource
    ProductOrderService productOrderService;

    @Resource
    UserBuyProductVoMapper userBuyProductVoMapper;

    @Resource
    UserService userService;

    @RequestMapping("/productorder_page")
    public String ProductOrderPage(@RequestParam(value = "productorder_code",defaultValue = "") String productorder_code,
                                   @RequestParam(value = "productorder_status",defaultValue = "-1") Integer productorder_status,
                                   @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("productorder_code",productorder_code);
        map.put("productorder_status",productorder_status);
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        int allCount = productOrderService.GetAllCount(map);
        List<ProductOrder> productOrders = productOrderService.GetPageProductOrders(map);
        PageUtil  pageUtil=new PageUtil(pageIndex,pageSize,allCount,productOrders);
        model.addAttribute("productorder_code",productorder_code);
        model.addAttribute("productorder_status",productorder_status);
        model.addAttribute("pageUtil",pageUtil);
        return "orderManagerPage";
    }

    @RequestMapping("/productorder_detail/{productorder_id}")
    public String ProductorderDetail(@PathVariable("productorder_id") Integer productorder_id, Model model){


        ProductOrder productOrder = productOrderService.GetAProductOrder(productorder_id);
        UserBuyProductVo userBuyProductVo = userBuyProductVoMapper.GetAUserBuyProductVo(productOrder.getProductorder_id());
        String productImage = userBuyProductVoMapper.GetProductImage(userBuyProductVo.getProduct_id());
        User user = userService.GetUserById(productOrder.getProductorder_user_id());
        List<String> userAddress = userService.GetUserAddress(user.getUser_address());
        StringBuffer sb=new StringBuffer();
        for (String address : userAddress) {
            sb.append(address).append("  ");
        }
        model.addAttribute("receiveAddress",sb.toString());
        model.addAttribute("user",user);
        model.addAttribute("productOrder",productOrder);
        model.addAttribute("userBuyProductVo",userBuyProductVo);
        model.addAttribute("productImage",productImage);
        return "orderDetailPage";
    }

}
