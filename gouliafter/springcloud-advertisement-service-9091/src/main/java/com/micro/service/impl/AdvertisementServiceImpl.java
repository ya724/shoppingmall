package com.micro.service.impl;

import com.micro.mapper.AdvertisementMapper;
import com.micro.pojo.Advertisement;
import com.micro.service.AdvertisementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service.impl
 * @CreateTime: 2020-11-19 09:44
 * @Description: TODO
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Resource
    AdvertisementMapper advertisementMapper;

    @Override
    public List<Advertisement> findAdvertisementsBycategory_id(Integer advertisement_category_id) {
        return advertisementMapper.findAdvertisementsBycategory_id(advertisement_category_id);
    }
}
