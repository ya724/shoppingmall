package com.it.mapper;

import com.it.bean.AdvertisementCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdvertisementCategoryMapper {
    int GetAllCount();
    List<AdvertisementCategory> GetPageAdvertisementCategorys(Map<String,Object> map);
    int AddAdvertisementCategory(String name);
    int DeleteAdvertisementCategory(Integer id);
    int UpdateAdvertisementCategory(AdvertisementCategory advertisementCategory);
    AdvertisementCategory GetAdvertisementCategoryById(Integer id);
}
