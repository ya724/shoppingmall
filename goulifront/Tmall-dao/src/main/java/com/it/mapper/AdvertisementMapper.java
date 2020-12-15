package com.it.mapper;

import com.it.bean.Advertisement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdvertisementMapper {
    List<Advertisement> GetAdvertisementsById(Integer advertisement_category_id,Integer status);

    int AdvertisementAdd(Advertisement advertisement);
}
