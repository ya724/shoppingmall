package com.micro.service;

import com.micro.pojo.Review;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service
 * @CreateTime: 2020-11-26 10:37
 * @Description: TODO
 */
public interface ReviewService {

    List<Review> findReviewsByProductId(Integer product_id);

    Integer getReviewCount(Integer product_id);
}
