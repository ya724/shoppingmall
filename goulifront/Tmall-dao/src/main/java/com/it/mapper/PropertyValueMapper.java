package com.it.mapper;

import com.it.bean.PropertyValue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PropertyValueMapper {
    int PropertyValueAdd(PropertyValue propertyValue);
}
