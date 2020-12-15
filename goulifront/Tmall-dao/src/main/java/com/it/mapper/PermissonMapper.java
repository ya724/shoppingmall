package com.it.mapper;

import com.it.bean.Permisson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissonMapper {
    List<Permisson> GetPermissonsByAdminId(@Param("admin_id") Integer admin_id, @Param("type") String type);
}
