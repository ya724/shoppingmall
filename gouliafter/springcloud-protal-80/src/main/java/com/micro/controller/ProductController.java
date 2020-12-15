package com.micro.controller;

import com.micro.api.ProductServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    ProductServiceApi productServiceApi;

    @RequestMapping("/product/{product_id}")
    public String findProductDetails(@PathVariable("product_id") Integer product_id, Model model) {
        Map<String, Object> productDetails = productServiceApi.findProductDetails(product_id);
        log.info("productDetails=" + productDetails);
        model.addAttribute("propertyBeans", productDetails.get("propertyBeans"));
        model.addAttribute("productImages", productDetails.get("productImages"));
        model.addAttribute("reviews", productDetails.get("reviews"));
        model.addAttribute("reviewCount", productDetails.get("reviewCount"));
        model.addAttribute("saleCount", productDetails.get("saleCount"));
        return "details";
    }
}