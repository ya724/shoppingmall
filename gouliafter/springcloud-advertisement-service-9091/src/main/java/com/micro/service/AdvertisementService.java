package com.micro.service;

import com.micro.pojo.Advertisement;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service
 * @CreateTime: 2020-11-19 09:44
 * @Description: TODO
 */
public interface AdvertisementService {

    List<Advertisement> findAdvertisementsBycategory_id(Integer advertisement_category_id);
}
