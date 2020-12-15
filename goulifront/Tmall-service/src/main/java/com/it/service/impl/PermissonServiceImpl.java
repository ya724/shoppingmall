package com.it.service.impl;

import com.it.bean.Permisson;
import com.it.mapper.PermissonMapper;
import com.it.service.PermissonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissonServiceImpl implements PermissonService {

    @Resource
    PermissonMapper permissonMapper;
    @Override
    public List<Permisson> GetPermissonsByAdminId(Integer admin_id,String type) {
        return permissonMapper.GetPermissonsByAdminId(admin_id,type);
    }
}
