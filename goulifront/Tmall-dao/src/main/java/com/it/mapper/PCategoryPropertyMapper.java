package com.it.mapper;

import com.it.bean.PCategoryProperty;
import com.it.bean.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PCategoryPropertyMapper {
    int addPCategoryProperty(PCategoryProperty pCategoryProperty);

    List<PCategoryProperty> GetProductPorperty(Integer property_category_id);

    PCategoryProperty  PCategoryPropertyAdd(PCategoryProperty  pCategoryProperty);
}
