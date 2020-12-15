package com.it.service;

import com.it.bean.ProductCategory;

import java.util.List;
import java.util.Map;


public interface ProductCategoryService {

    int GetAllCount(Map<String,Object> map);
    List<ProductCategory> GetPageProductCategorys(Map<String,Object> map);

    ProductCategory
    findById(Integer parent_id);

    int ProductCategoryAdd(ProductCategory productCategory);

    int ProductCategoryAdd(ProductCategory productCategory,String[] propertyname);

    List<ProductCategory> GetAllCategorys(Integer parent_id);
}
