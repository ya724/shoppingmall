package com.it.service.impl;

import com.it.bean.User;
import com.it.mapper.UserMapper;
import com.it.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User UserLogin(User user) {
        return userMapper.UserLogin(user);
    }

    @Override
    public Integer GetAllCount(Map<String, Object> map) {
        return userMapper.GetAllCount(map);
    }

    @Override
    public List<User> GetPageUsers(Map<String, Object> map) {
        return userMapper.GetPageUsers(map);
    }

    @Override
    public User GetUserById(Integer user_id) {
        return userMapper.GetUserById(user_id);
    }

    @Override
    public List<String> GetUserAddress(String user_address) {
        return userMapper.GetUserAddress(user_address);
    }

    @Override
    public String GetUserHomeplace(String user_homeplace) {
        return userMapper.GetUserHomeplace(user_homeplace);
    }

    @Override
    public Integer GetRegisterUsers() {
        return userMapper.GetRegisterUsers();
    }


}
