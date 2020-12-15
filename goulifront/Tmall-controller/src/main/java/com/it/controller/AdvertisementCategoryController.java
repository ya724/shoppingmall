package com.it.controller;

import com.it.bean.AdvertisementCategory;
import com.it.service.AdvertisementCategoryService;
import com.it.utils.PageUtil;
import com.it.utils.ResultCode;
import com.it.utils.ResultCommon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdvertisementCategoryController {
    @Resource
    AdvertisementCategoryService advertisementCategoryService;

    @RequestMapping("/advertisementcategory_page")
    public String  AdvertisementCategoryPage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                             @RequestParam(value = "pageSize",defaultValue = "4") Integer pageSize,
                                             Model model){
        int allCount = advertisementCategoryService.GetAllCount();
        Map<String,Object> map=new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<AdvertisementCategory> advertisementCategories = advertisementCategoryService.GetPageAdvertisementCategorys(map);
        PageUtil pageUtil=new PageUtil(pageIndex,pageSize,allCount,advertisementCategories);

        model.addAttribute("pageUtil",pageUtil);

        return "advertisementManagePage";
    }


    @ResponseBody
    @RequestMapping("/advertisementcategory_add")
    public ResultCommon AdvertisementCategoryAdd(String name){

       int count = advertisementCategoryService.AddAdvertisementCategory(name);
        if(count>0){
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }
    }
    @RequestMapping("/advertisementcategory_delete")
    public ResultCommon AdvertisementCategoryDelete(Integer id){

        int count = advertisementCategoryService.DeleteAdvertisementCategory(id);
        if(count>0){
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }
    }
    @RequestMapping("/advertisementcategory_update")
    public ResultCommon AdvertisementCategoryAdd(AdvertisementCategory advertisementCategory){

        int count = advertisementCategoryService.UpdateAdvertisementCategory(advertisementCategory);
        if(count>0){
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }
    }
}
