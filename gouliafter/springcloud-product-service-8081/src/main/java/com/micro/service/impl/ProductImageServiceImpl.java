package com.micro.service.impl;

import com.micro.mapper.ProductImageMapper;
import com.micro.pojo.ProductImage;
import com.micro.service.ProductImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service.impl
 * @CreateTime: 2020-11-26 10:36
 * @Description: TODO
 */
@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Resource
    ProductImageMapper productImageMapper;

    @Override
    public List<ProductImage> findProductImages(Integer product_id) {
        return productImageMapper.findProductImages(product_id);
    }
}
