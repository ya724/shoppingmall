package com.it.mapper;

import com.it.bean.ProductImage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductImageMapper {
    int ProductImageAdd(ProductImage productImage);

}
