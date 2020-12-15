package com.it.service;

import com.it.bean.AdvertisementCategory;

import java.util.List;
import java.util.Map;

public interface AdvertisementCategoryService {
    int GetAllCount();
    List<AdvertisementCategory> GetPageAdvertisementCategorys(Map<String,Object> map);
    int AddAdvertisementCategory(String name);
    int DeleteAdvertisementCategory(Integer id);
    int UpdateAdvertisementCategory(AdvertisementCategory advertisementCategory);
    AdvertisementCategory GetAdvertisementCategoryById(Integer id);
}
