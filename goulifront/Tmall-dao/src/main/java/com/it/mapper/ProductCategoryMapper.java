package com.it.mapper;

import com.it.bean.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductCategoryMapper {
    int GetAllCount(Map<String,Object> map);
    List<ProductCategory> GetPageProductCategorys(Map<String,Object> map);

    ProductCategory findById(Integer product_category_id);

    int ProductCategoryAdd(ProductCategory productCategory);

    List<ProductCategory> GetAllCategorys(Integer parent_id);
}
