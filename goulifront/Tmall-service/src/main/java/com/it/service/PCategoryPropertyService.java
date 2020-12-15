package com.it.service;

import com.it.bean.PCategoryProperty;

import java.util.List;

public interface PCategoryPropertyService {
    int addPCategoryProperty(PCategoryProperty pCategoryProperty);

    List<PCategoryProperty> GetProductPorperty(Integer property_category_id);
}
