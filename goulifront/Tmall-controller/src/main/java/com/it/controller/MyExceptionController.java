package com.it.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionController {

    @ExceptionHandler(UnauthorizedException.class)
    //@ResponseBody
    public String resolveException(UnauthorizedException e) {
        System.out.println("没有权限");
        return "nopermission";
    }



}
