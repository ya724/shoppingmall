package com.it.service;

import com.it.bean.Advertisement;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> GetAdvertisementsById(Integer advertisement_category_id, Integer status);
    int AdvertisementAdd(Advertisement advertisement);
}
