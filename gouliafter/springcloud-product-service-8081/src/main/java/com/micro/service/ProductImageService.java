package com.micro.service;

import com.micro.pojo.ProductImage;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service
 * @CreateTime: 2020-11-26 10:36
 * @Description: TODO
 */
public interface ProductImageService {
    List<ProductImage> findProductImages(Integer product_id);
}
