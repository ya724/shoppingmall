package com.micro.service;

import com.micro.pojo.ProductCategory;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service
 * @CreateTime: 2020-11-19 10:58
 * @Description: TODO
 */
public interface ProductCategoryService {

    List<ProductCategory> findProductCategorys();
}
