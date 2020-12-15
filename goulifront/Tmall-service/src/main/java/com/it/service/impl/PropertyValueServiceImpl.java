package com.it.service.impl;

import com.it.bean.PropertyValue;
import com.it.mapper.PropertyValueMapper;
import com.it.service.PropertyValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Resource
    PropertyValueMapper propertyValueMapper;
    @Override
    public int PropertyValueAdd(PropertyValue propertyValue) {
        return  propertyValueMapper.PropertyValueAdd(propertyValue);
    }
}
