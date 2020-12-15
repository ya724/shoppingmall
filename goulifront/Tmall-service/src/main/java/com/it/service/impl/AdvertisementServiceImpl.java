package com.it.service.impl;

import com.it.bean.Advertisement;
import com.it.mapper.AdvertisementMapper;
import com.it.service.AdvertisementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Resource
    AdvertisementMapper advertisementMapper;
    @Override
    public List<Advertisement> GetAdvertisementsById(Integer advertisement_category_id, Integer status) {
        return advertisementMapper.GetAdvertisementsById(advertisement_category_id,status);
    }

    @Override
    public int AdvertisementAdd(Advertisement advertisement) {
        return advertisementMapper.AdvertisementAdd(advertisement);
    }
}
