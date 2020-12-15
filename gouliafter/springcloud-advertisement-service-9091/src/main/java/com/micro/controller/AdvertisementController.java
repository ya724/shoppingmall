package com.micro.controller;

import com.micro.pojo.Advertisement;
import com.micro.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-19 09:45
 * @Description: TODO
 */
@RestController
public class AdvertisementController {

    @Autowired
    AdvertisementService advertisementService;

    /**
     * 根据列表查询广告数据
     * @param
     * @return
     */
    @RequestMapping("/advertisement_findAdvertisements")
    public List<Advertisement> findAdvertisementsBycategory_id(@RequestParam("advertisement_category_id") Integer advertisement_category_id){
        return  advertisementService.findAdvertisementsBycategory_id(advertisement_category_id);
    }

}
