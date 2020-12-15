package com.it.mapper;


import com.it.bean.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    int GetAllCount(Map<String,Object> map);
    List<Product> GetPageProducts(Map<String,Object> map);
    int ProductAdd(Product product);

    int GetOnlineProducts();
}
