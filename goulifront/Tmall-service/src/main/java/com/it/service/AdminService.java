package com.it.service;

import com.it.bean.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin AdminLogin(Admin admin);

    int UpdateAdmin(Admin admin);

    List<Admin> GetAdminsPage(Map<String,Object> map);

    Integer GetAllCount();

    Admin GetAdminByAdminName(String admin_name);
}
