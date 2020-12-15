package com.it.service;

import com.it.bean.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRoleByAdmin_Id(Integer admin_id);

    List<Role> findRoles();
}
