package com.micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-19 15:33
 * @Description: TODO
 */
@Controller
public class CommonController {

    @RequestMapping("/page/{page}")
    public String go(@PathVariable("page") String page){
        return page;
    }
}
