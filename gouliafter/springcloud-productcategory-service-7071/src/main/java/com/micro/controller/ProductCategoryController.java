package com.micro.controller;

import com.micro.pojo.ProductCategory;
import com.micro.service.ProductCategoryService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-19 10:59
 * @Description: TODO
 */
@RestController
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    /**
     * 商品列表接口
     * @return
     */
    @RequestMapping("/productcategory_findProductCategorys")
    public List<ProductCategory> findProductCategorys(){
        return productCategoryService.findProductCategorys();
    }
}
