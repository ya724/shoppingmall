package com.micro.mapper;

import com.micro.pojo.ProductImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductImageMapper {
    List<ProductImage> findProductImages(Integer product_id);
}
