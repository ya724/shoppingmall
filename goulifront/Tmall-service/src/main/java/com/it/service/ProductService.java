package com.it.service;

import com.it.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int GetAllCount(Map<String,Object> map);
    List<Product> GetPageProducts(Map<String,Object> map);
    int ProductAdd(Product product);

    int  ProductAdd(Product product,String[]  singleImagesArray,String[] detailsImagesArray, Integer[] propertyvalue_property_id,String[] propertyvalue_value);

    int GetOnlineProducts();
}
