package com.micro.controller;

import com.micro.api.AdvertisementClient;
import com.micro.api.ProductCategoryClient;
import com.micro.api.ProductServiceApi;
import com.micro.pojo.Advertisement;
import com.micro.pojo.Product;
import com.micro.pojo.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-17 09:56
 * @Description: TODO
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    ProductServiceApi productServiceApi;

    @Autowired
    AdvertisementClient advertisementClient;

    @Autowired
    ProductCategoryClient productCategoryClient;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    /**
     * 01-天猫首页
     *
     * @return
     */
    @RequestMapping({"/index", "/"})
    public String indexData(Model model) {
        List<Product> products_1233 = productServiceApi.findProductsByCategory(1251);

        List<Advertisement> advertisements_round = advertisementClient.findAdvertisementsBycategory_id(1);
        List<Advertisement> advertisements_gilrs = advertisementClient.findAdvertisementsBycategory_id(5);
        //List<Advertisement> advertisements_boys = advertisementClient.findAdvertisementsBycategory_id(3);

        //查询分类,所有的分类
        List<ProductCategory> productCategorys = productCategoryClient.findProductCategorys();
        //一级分类 16个
        List<ProductCategory> root_productCategorys=root_cates(productCategorys);
        //女装大衣数据
        model.addAttribute("products_1233", products_1233);
        //首页轮播图广告
        model.addAttribute("advertisements_round", advertisements_round);
        //女装大衣广告
        model.addAttribute("advertisements_gilrs", advertisements_gilrs);
        //男装户外广告
      //  model.addAttribute("advertisements_boys", advertisements_boys);
        //商品分类集合
        model.addAttribute("root_productCategorys", root_productCategorys);
        //所有商品的类目
        model.addAttribute("productCategorys", productCategorys);
        return "index";
    }

    /**
     * 获取一级分类
     *
     * @return
     */
    public List<ProductCategory> root_cates(List<ProductCategory> productCategorys) {
        List<ProductCategory> root_productCategorys = new ArrayList<>();
        int count=0;
        for (ProductCategory productCategory : productCategorys) {
            if (productCategory.getParent_id().toString().equals("0")) {
                count++;
                root_productCategorys.add(productCategory);
            }
            if(count==16){
                break;
            }
        }
        return root_productCategorys;
    }


}
