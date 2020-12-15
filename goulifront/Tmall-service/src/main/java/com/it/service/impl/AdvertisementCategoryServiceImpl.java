package com.it.service.impl;

import com.it.bean.AdvertisementCategory;
import com.it.mapper.AdvertisementCategoryMapper;
import com.it.service.AdvertisementCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdvertisementCategoryServiceImpl implements AdvertisementCategoryService {
    @Resource
    AdvertisementCategoryMapper advertisementCategoryMapper;

    @Override
    public int GetAllCount() {
        return advertisementCategoryMapper.GetAllCount();
    }

    @Override
    public List<AdvertisementCategory> GetPageAdvertisementCategorys(Map<String, Object> map) {
        return advertisementCategoryMapper.GetPageAdvertisementCategorys(map);
    }

    @Override
    public int AddAdvertisementCategory(String name) {
        return advertisementCategoryMapper.AddAdvertisementCategory(name);
    }

    @Override
    public int DeleteAdvertisementCategory(Integer id) {
        return advertisementCategoryMapper.DeleteAdvertisementCategory(id);
    }

    @Override
    public int UpdateAdvertisementCategory(AdvertisementCategory advertisementCategory) {
        return advertisementCategoryMapper.UpdateAdvertisementCategory(advertisementCategory);
    }

    @Override
    public AdvertisementCategory GetAdvertisementCategoryById(Integer id) {
        return advertisementCategoryMapper.GetAdvertisementCategoryById(id);
    }
}
