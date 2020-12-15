package com.it.service.impl;


import com.it.bean.PCategoryProperty;
import com.it.mapper.PCategoryPropertyMapper;
import com.it.service.PCategoryPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;
import java.util.List;

@Service
public class PCategoryPropertyServiceImpl implements PCategoryPropertyService {

    @Resource
    PCategoryPropertyMapper pCategoryPropertyMapper;

    @Override
    public int addPCategoryProperty(PCategoryProperty pCategoryProperty) {
        return pCategoryPropertyMapper.addPCategoryProperty(pCategoryProperty);
    }

    @Override
    public List<PCategoryProperty> GetProductPorperty(Integer property_category_id) {
        return pCategoryPropertyMapper.GetProductPorperty(property_category_id);
    }
}
