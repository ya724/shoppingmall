package com.micro.api;

import com.micro.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.api
 * @CreateTime: 2020-11-19 15:43
 * @Description: TODO
 */
@FeignClient(value = "user-service")
public interface UserServiceClient {

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/user_add")
    public Integer add(@RequestBody User user);
}
