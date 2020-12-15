package com.it.service.impl;

import com.it.bean.ProductImage;
import com.it.mapper.ProductImageMapper;
import com.it.service.ProductImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Resource
    ProductImageMapper productImageMapper;
    @Override
    public int ProductImageAdd(ProductImage productImage) {
        return productImageMapper.ProductImageAdd(productImage);
    }
}
