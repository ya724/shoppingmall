package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/")
    public String CommonJumpPage(){
        return "loginPage";
    }


    @RequestMapping("/page_{target}")
    public String CommonJumpPage(@PathVariable("target") String target ){
        return target;
    }
}
