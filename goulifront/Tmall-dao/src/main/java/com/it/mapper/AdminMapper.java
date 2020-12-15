package com.it.mapper;


import com.it.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    Admin AdminLogin(Admin admin);

    int UpdateAdmin(Admin admin);

    List<Admin> GetAdminsPage(Map<String,Object> map);

    Integer GetAllCount();

    Admin GetAdminByAdminName(String admin_name);
}
