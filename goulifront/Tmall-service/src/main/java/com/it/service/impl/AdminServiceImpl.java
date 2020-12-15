package com.it.service.impl;


import com.it.bean.Admin;
import com.it.mapper.AdminMapper;
import com.it.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;
    @Override
    public Admin AdminLogin(Admin admin) {
        return adminMapper.AdminLogin(admin);
    }

    @Override
    public int UpdateAdmin(Admin admin) {
        return adminMapper.UpdateAdmin(admin);
    }

    @Override
    public List<Admin> GetAdminsPage(Map<String, Object> map) {
        return adminMapper.GetAdminsPage(map);
    }

    @Override
    public Integer GetAllCount() {
        return adminMapper.GetAllCount();
    }

    @Override
    public Admin GetAdminByAdminName(String admin_name) {
        return adminMapper.GetAdminByAdminName(admin_name);
    }
}
