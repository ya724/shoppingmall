package com.it.mapper;

import com.it.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    User UserLogin(User user);
    Integer GetAllCount(Map<String,Object> map);
    List<User> GetPageUsers(Map<String,Object> map);
    User GetUserById(Integer user_id);
   List<String> GetUserAddress(String user_address);
    String GetUserHomeplace(String user_homeplace);
    Integer GetRegisterUsers();
}
