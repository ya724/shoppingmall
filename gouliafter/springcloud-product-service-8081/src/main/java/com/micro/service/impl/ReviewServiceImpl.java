package com.micro.service.impl;

import com.micro.mapper.ReviewMapper;
import com.micro.pojo.Review;
import com.micro.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service.impl
 * @CreateTime: 2020-11-26 10:37
 * @Description: TODO
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Resource
    ReviewMapper reviewMapper;

    @Override
    public List<Review> findReviewsByProductId(Integer product_id) {
        return reviewMapper.findReviewsByProductId(product_id);
    }

    @Override
    public Integer getReviewCount(Integer product_id) {
        return reviewMapper.getReviewCount(product_id);
    }
}
