package com.it.mapper;

import com.it.bean.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> findRoleByAdmin_Id(Integer admin_id);

    List<Role> findRoles();
}
