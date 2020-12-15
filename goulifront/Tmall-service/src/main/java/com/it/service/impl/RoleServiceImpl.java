package com.it.service.impl;

import com.it.bean.Role;
import com.it.mapper.RoleMapper;
import com.it.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;
    @Override
    public List<Role> findRoleByAdmin_Id(Integer admin_id) {
        return roleMapper.findRoleByAdmin_Id(admin_id);
    }

    @Override
    public List<Role> findRoles() {
        return roleMapper.findRoles();
    }
}
