package com.micro.mapper;

import com.micro.pojo.Advertisement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.mapper
 * @CreateTime: 2020-11-19 09:40
 * @Description: TODO
 */
@Mapper
public interface AdvertisementMapper {

    List<Advertisement> findAdvertisementsBycategory_id(Integer advertisement_category_id);
}
