package com.it.service;

import com.it.bean.Permisson;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PermissonService {
    List<Permisson> GetPermissonsByAdminId(Integer admin_id, String type);
}
