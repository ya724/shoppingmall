package com.it.controller;

import com.it.bean.ProductCategory;
import com.it.service.ProductCategoryService;
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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
public class ProductCategoryController {
    @Resource
    ProductCategoryService productCategoryService;

    @RequestMapping("/productcategory_page")
    public String ProductCategoryPage(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "product_category_name", defaultValue = "") String product_category_name,
                                      @RequestParam(value = "parent_id", defaultValue = "0") Integer parent_id,
                                      Model model) {

        System.out.println("父id：" + parent_id);
        Map<String, Object> map = new HashMap<>();
        map.put("parent_id", parent_id);
        int allCount = productCategoryService.GetAllCount(map);
        map.put("product_category_name", product_category_name);
        map.put("pageStart", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);

        List<ProductCategory> productCategories = productCategoryService.GetPageProductCategorys(map);
        PageUtil pageUtil = new PageUtil(pageIndex, pageSize, allCount, productCategories);

        boolean flag3 = false;//是否是三级类目
        boolean flag2 = false;//是否是三级类目
        //动态生成页面的导航条
        StringBuffer sb = new StringBuffer("<span><a href=\"/productcategory_page\">顶级分类</a></span>");
        if (!parent_id.toString().equals("0")) {
            ProductCategory category = productCategoryService.findById(parent_id);
            String name = category.getProduct_category_name();
            String str1 = " > <span><a href=\"/productcategory_page?parent_id=" + category.getProduct_category_id() + "\">" + name + "</a></span>";
            Integer parent_id1 = category.getParent_id();
            ProductCategory category1 = productCategoryService.findById(parent_id1);
            flag2=true;
            if (category1 != null) {
                String name1 = category1.getProduct_category_name();
                String str2 = " > <span><a href=\"/productcategory_page?parent_id=" + category1.getProduct_category_id() + "\">" + name1 + "</a></span>";
                sb.append(str2);
                flag3 = true; //表示已经是第三级类目
            }
            sb.append(str1);
        }
        model.addAttribute("flag2", flag2);
        model.addAttribute("flag3", flag3);
        model.addAttribute("menus", sb.toString());
        model.addAttribute("product_category_name", product_category_name);
        model.addAttribute("pageUtil", pageUtil);
        model.addAttribute("parent_id",parent_id);

        return "productCategoryManagePage";
    }

    @ResponseBody
    @RequestMapping("/productcategory_add")
    public ResultCommon ProductcategoryAdd(ProductCategory productCategory){

       int count=productCategoryService.ProductCategoryAdd(productCategory);
        if(count>0){
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }
    }


    @RequestMapping("/productcategory_toadd2")
    public String ProductcategoryToAdd2(@RequestParam("parent_id") Integer parent_id,Model model){
        ProductCategory productCategory = productCategoryService.findById(parent_id);
        model.addAttribute("productCategory",productCategory);
        return "productCategoryAdd2Page";
    }

    @RequestMapping("/productcategory_toadd3")
    public String ProductcategoryToAdd3(@RequestParam("parent_id") Integer parent_id,Model model){
        ProductCategory productCategory = productCategoryService.findById(parent_id);
        //System.out.println(productCategory);
        model.addAttribute("productCategory",productCategory);
        return "productCategoryAdd3Page";
    }

    @ResponseBody
    @RequestMapping("/productcategory_add3")
    public ResultCommon ProductcategoryAdd3(ProductCategory productCategory,String[] propertyname){


        int count=productCategoryService.ProductCategoryAdd(productCategory,propertyname);
        if(count>0){
            return ResultCommon.success(ResultCode.SUCCESS);
        }else {
            return ResultCommon.fail(ResultCode.FAIL);
        }
    }


}