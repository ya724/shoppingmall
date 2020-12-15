package com.micro.api;

import com.micro.fallback.AdvertisementClientFallback;
import com.micro.pojo.Advertisement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.api
 * @CreateTime: 2020-11-19 09:51
 * @Description: TODO
 */
@FeignClient(value = "advertisement-service",fallbackFactory = AdvertisementClientFallback.class)
public interface AdvertisementClient {

    /**
     * 根据列表查询广告数据
     * @param
     * @return
     */
    @RequestMapping("/advertisement_findAdvertisements")
    public List<Advertisement> findAdvertisementsBycategory_id(@RequestParam("product_category_id") Integer product_category_id);
}
