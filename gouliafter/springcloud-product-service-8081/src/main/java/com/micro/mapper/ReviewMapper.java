package com.micro.mapper;

import com.micro.pojo.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    List<Review> findReviewsByProductId(Integer product_id);

    Integer getReviewCount(Integer product_id);
}
