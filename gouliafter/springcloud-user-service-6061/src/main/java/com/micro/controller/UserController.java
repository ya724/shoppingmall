package com.micro.controller;

import com.micro.pojo.User;
import com.micro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-19 16:08
 * @Description: TODO
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/user_add")
    public Integer add(@RequestBody User user) {
        System.out.println("要注册的对象:" + user);
        return userService.register(user);
    }
}
