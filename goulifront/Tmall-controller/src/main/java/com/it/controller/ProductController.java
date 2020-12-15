package com.it.controller;


import com.it.bean.PCategoryProperty;
import com.it.bean.Product;
import com.it.bean.ProductCategory;
import com.it.service.PCategoryPropertyService;
import com.it.service.ProductCategoryService;
import com.it.service.ProductService;
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
public class ProductController {
    @Resource
    ProductService productService;

    @Resource
    ProductCategoryService productCategoryService;

    @Resource
    PCategoryPropertyService pCategoryPropertyService;

    @RequestMapping("/product_page")
    public String ProductPage(@RequestParam(value = "product_name",required = false,defaultValue = "") String product_name,
                              @RequestParam(value = "product_isEnabled",required = false,defaultValue = "-1") Integer product_isEnabled,
                              @RequestParam(value = "startPrice",required = false,defaultValue = "") Double startPrice,
                              @RequestParam(value = "endPrice",required = false,defaultValue = "") Double endPrice,
                              @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize, Model model){

        Map<String,Object> map=new HashMap<>();
        map.put("product_name",product_name);
        map.put("product_isEnabled",product_isEnabled);
        map.put("startPrice",startPrice);
        map.put("endPrice",endPrice);
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        int allCount = productService.GetAllCount(map);
        List<Product> products = productService.GetPageProducts(map);
        PageUtil pageUtil=new PageUtil(pageIndex,pageSize,allCount,products);
        model.addAttribute("pageUtil",pageUtil);
        model.addAttribute("map",map);
        return "productManagePage";
    }

    @ResponseBody
    @RequestMapping("/productcategory_all")
    public ResultCommon GetAllProductCategorys(@RequestParam(value = "parent_id",required = false,defaultValue = "0") Integer parent_id){
        List<ProductCategory> productCategories = productCategoryService.GetAllCategorys(parent_id);

        if(productCategories!=null){
            return ResultCommon.success(ResultCode.SUCCESS,productCategories);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }

    }

    @ResponseBody
    @RequestMapping("/productproperty")
    public ResultCommon GetProductProperty( Integer property_category_id){

      List<PCategoryProperty> pCategoryProperties= pCategoryPropertyService.GetProductPorperty(property_category_id);

        if(pCategoryProperties!=null){
            return ResultCommon.success(ResultCode.SUCCESS,pCategoryProperties);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }

    }

    @ResponseBody
    @RequestMapping("/product_add")
    public ResultCommon ProductAdd(Product product,String[]  singleImagesArray,String[] detailsImagesArray, Integer[] propertyvalue_property_id,String[] propertyvalue_value){


       int count=productService.ProductAdd(product,singleImagesArray,detailsImagesArray,propertyvalue_property_id,propertyvalue_value);

        if(count>0){
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }

    }


}
