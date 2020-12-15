package com.micro.service.impl;

import com.micro.mapper.UserMapper;
import com.micro.pojo.User;
import com.micro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service.impl
 * @CreateTime: 2020-11-19 16:07
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Integer register(User user) {
        return userMapper.register(user);
    }
}
