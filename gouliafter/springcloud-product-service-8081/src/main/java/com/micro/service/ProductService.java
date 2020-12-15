package com.micro.service;

import com.micro.pojo.Product;
import com.micro.pojo.ProductImage;
import com.micro.pojo.PropertyBean;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service
 * @CreateTime: 2020-11-16 19:31
 * @Description: TODO
 */
public interface ProductService {

    List<Product> findProducts();

    List<Product> findProductsByCategory(Integer product_category_id);

    List<ProductImage> findProductSmallImage(Integer product_id);

    Product findById(Integer product_id);

    List<PropertyBean> findPropertyBeans(Integer product_id);

    Integer getSaleCount(Integer product_id);

    String queryProductImagesByProduct_id(Integer product_id);
}
