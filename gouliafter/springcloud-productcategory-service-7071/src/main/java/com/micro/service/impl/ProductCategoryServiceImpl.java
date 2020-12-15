package com.micro.service.impl;

import com.micro.mapper.ProductCategoryMapper;
import com.micro.pojo.ProductCategory;
import com.micro.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service.impl
 * @CreateTime: 2020-11-19 10:58
 * @Description: TODO
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findProductCategorys() {
        return productCategoryMapper.findProductCategorys();
    }
}
