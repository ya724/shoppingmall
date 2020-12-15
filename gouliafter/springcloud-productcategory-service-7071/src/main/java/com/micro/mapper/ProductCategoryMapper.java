package com.micro.mapper;

import com.micro.pojo.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.mapper
 * @CreateTime: 2020-11-19 10:54
 * @Description: TODO
 */
@Mapper
public interface ProductCategoryMapper {

    List<ProductCategory> findProductCategorys();
}
