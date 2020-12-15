package com.micro.service.impl;

import com.micro.mapper.ProductMapper;
import com.micro.pojo.Product;
import com.micro.pojo.ProductImage;
import com.micro.pojo.PropertyBean;
import com.micro.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service.impl
 * @CreateTime: 2020-11-16 19:31
 * @Description: TODO
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public List<Product> findProducts() {
        return productMapper.findProducts();
    }

    @Override
    public List<Product> findProductsByCategory(Integer product_category_id) {
        return productMapper.findProductsByCategory(product_category_id);
    }

    @Override
    public List<ProductImage> findProductSmallImage(Integer product_id) {
        return productMapper.findProductSmallImage(product_id);
    }

    @Override
    public Product findById(Integer product_id) {
        return productMapper.findById(product_id);
    }

    @Override
    public List<PropertyBean> findPropertyBeans(Integer product_id) {
        return productMapper.findPropertyBeans(product_id);
    }

    @Override
    public Integer getSaleCount(Integer product_id) {
        return productMapper.getSaleCount(product_id);
    }

    @Override
    public String queryProductImagesByProduct_id(Integer product_id) {
        return productMapper.queryProductImagesByProduct_id(product_id);
    }
}
