package com.micro.mapper;

import com.micro.pojo.Product;
import com.micro.pojo.ProductImage;
import com.micro.pojo.PropertyBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.mapper
 * @CreateTime: 2020-11-16 19:27
 * @Description: TODO
 */
@Mapper
public interface ProductMapper {

    List<Product> findProducts();

    List<Product> findProductsByCategory(Integer product_category_id);

    List<ProductImage> findProductSmallImage(Integer product_id);

    Product findById(Integer product_id);

    List<PropertyBean> findPropertyBeans(Integer product_id);

    Integer getSaleCount(Integer product_id);

    String queryProductImagesByProduct_id(Integer product_id);


}
