package com.micro.api;

import com.micro.pojo.ProductCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.api
 * @CreateTime: 2020-11-19 11:03
 * @Description: TODO
 */
@FeignClient(value = "product-category-service")
public interface ProductCategoryClient {

    /**
     * 商品列表接口
     * @return
     */
    @RequestMapping("/productcategory_findProductCategorys")
    public List<ProductCategory> findProductCategorys();
}
