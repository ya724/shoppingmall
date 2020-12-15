package com.it.service;

import com.it.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {


    User UserLogin(User user);

    Integer GetAllCount(Map<String, Object> map);

    List<User> GetPageUsers(Map<String, Object> map);

    User GetUserById(Integer user_id);

    List<String> GetUserAddress(String user_address);

    String GetUserHomeplace(String user_homeplace);

    Integer GetRegisterUsers();

}

