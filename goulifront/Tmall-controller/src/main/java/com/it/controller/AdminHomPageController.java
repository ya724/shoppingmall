package com.it.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.it.bean.OrderGroup;
import com.it.service.ProductOrderService;
import com.it.service.ProductService;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminHomPageController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    ProductOrderService productOrderService;

    @RequestMapping("/home_three")
    public String GetHomeThree(Model model) throws Exception {

        int onlineProducts = productService.GetOnlineProducts();
        Integer registerUsers = userService.GetRegisterUsers();
        Integer dealProductOrders = productOrderService.GetDealProductOrders();

        model.addAttribute("onlineProducts",onlineProducts);
        model.addAttribute("registerUsers",registerUsers);
        model.addAttribute("dealProductOrders",dealProductOrders);


        String jsonObject = getChartData(null, null);
        model.addAttribute("jsonObject", jsonObject);


        return "homePage";
    }

   //获取图表的JSON数据

    private String getChartData(Date beginDate, Date endDate) throws Exception {
        //时间格式化1
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
        //时间格式化2
        SimpleDateFormat timeSpecial = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK);
        if (beginDate == null || endDate == null) {
            //当前时间
            Calendar cal = Calendar.getInstance();
            //当前时间往前推7天
            cal.add(Calendar.DATE, -7);
            beginDate = time.parse(time.format(cal.getTime()));
            cal = Calendar.getInstance();
            //当前系统时间
            endDate = cal.getTime();
            endDate=timeSpecial.parse(time.format(endDate) + " 23:59:59");
        } else {
            //用户输入的时间
            beginDate = time.parse(time.format(beginDate));
            endDate = timeSpecial.parse(time.format(endDate) + " 23:59:59");
        }

        //长度为7的数组
        String[] dateStr = new String[7];  // [11/04, 11/05, 11/06, 11/07, 11/08, 11/09, 11/10]
        SimpleDateFormat time2 = new SimpleDateFormat("MM/dd", Locale.UK);
        //log.info("获取时间段数组");
        for (int i = 0; i < dateStr.length; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(beginDate);
            cal.add(Calendar.DATE, i);
            dateStr[i] = time2.format(cal.getTime());
        }
      //  log.info("获取时间段数组：" + Arrays.toString(dateStr));

      //  log.info("----获取总交易额订单列表详情：----");

        //总交易订单数组  // [11/04, 11/05, 11/06, 11/07, 11/08, 11/09, 11/10]
        int[] orderTotalArray = new int[7]; //默认值0
        //未付款订单数组
        int[] orderUnpaidArray = new int[7];
        //未发货订单叔祖
        int[] orderNotShippedArray = new int[7];
        //未确认订单数组
        int[] orderUnconfirmedArray = new int[7];
        //交易成功数组
        int[] orderSuccessArray = new int[7];

        List<OrderGroup> orderGroupList = productOrderService.findOrderGroups(timeSpecial.format(beginDate), timeSpecial.format(endDate));

        for (OrderGroup orderGroup : orderGroupList) {
            int index = 0;
            for (int j = 0; j < dateStr.length; j++) {
                if (dateStr[j].equals(orderGroup.getProductOrderCreateDate())) {
                    //记录日期所在下标
                    index = j;
                }
            }
            switch (orderGroup.getProductorder_status()) {
                case 0:
                    //待支付
                    orderUnpaidArray[index] = orderGroup.getProductOrder_count();
                    break;
                case 1:
                    //
                    orderNotShippedArray[index] = orderGroup.getProductOrder_count();
                    break;
                case 2:
                    orderUnconfirmedArray[index] = orderGroup.getProductOrder_count();
                    break;
                case 3:
                    orderSuccessArray[index] = orderGroup.getProductOrder_count();
                    break;
                case 4:
                    break;
                default:
                    throw new RuntimeException("错误的订单类型!");
            }
        }
       // log.info("获取总交易订单数组");
        for (int i = 0; i < dateStr.length; i++) {
            orderTotalArray[i] = orderUnpaidArray[i] + orderNotShippedArray[i] + orderUnconfirmedArray[i] + orderSuccessArray[i];
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderTotalArray", JSONArray.parseArray(JSON.toJSONString(orderTotalArray)));
        jsonObject.put("orderUnpaidArray", JSONArray.parseArray(JSON.toJSONString(orderUnpaidArray)));
        jsonObject.put("orderNotShippedArray", JSONArray.parseArray(JSON.toJSONString(orderNotShippedArray)));
        jsonObject.put("orderUnconfirmedArray", JSONArray.parseArray(JSON.toJSONString(orderUnconfirmedArray)));
        jsonObject.put("orderSuccessArray", JSONArray.parseArray(JSON.toJSONString(orderSuccessArray)));
        jsonObject.put("dateStr",JSONArray.parseArray(JSON.toJSONString(dateStr)));
        return jsonObject.toJSONString();
    }


    //按日期查询图表数据-ajax
    @ResponseBody
    @RequestMapping(value = "/admin_home_charts", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String getChartDataByDate(@RequestParam(required = false) String beginDate, @RequestParam(required = false) String endDate) throws Exception {
        if (beginDate != null && endDate != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return getChartData(simpleDateFormat.parse(beginDate), simpleDateFormat.parse(endDate));
        } else {
            return getChartData(null, null);
        }
    }

}
