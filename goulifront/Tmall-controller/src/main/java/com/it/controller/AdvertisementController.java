package com.it.controller;

import com.it.bean.Advertisement;
import com.it.bean.AdvertisementCategory;
import com.it.service.AdvertisementCategoryService;
import com.it.service.AdvertisementService;
import com.it.utils.ResultCode;
import com.it.utils.ResultCommon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AdvertisementController {
    @Resource
    AdvertisementService advertisementService;
    @Resource
    AdvertisementCategoryService advertisementCategoryService;

    @RequestMapping("/advertisement_info/{id}")
    public String AdvertisementInfo(Integer id, Model model,
                                    @RequestParam(value = "status",defaultValue = "") Integer status){

        List<Advertisement> advertisements = advertisementService.GetAdvertisementsById(id, status);

     return "/advertisementDetailPage";
    }
    @RequestMapping("/advertisement_addinfo/{id}")
    public String AdvertisementAddInfo(@PathVariable("id") Integer id, Model model){

        AdvertisementCategory advertisementCategory = advertisementCategoryService.GetAdvertisementCategoryById(id);
        model.addAttribute("advertisementCategory",advertisementCategory);

        return "/advertisementAddPage";
    }

    @ResponseBody
    @RequestMapping("/advertisement_add")
    public ResultCommon  AdvertisementAdd(Advertisement advertisement){
        System.out.println(advertisement);
        int count = advertisementService.AdvertisementAdd(advertisement);

        if(count>0){
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }
    }

}
