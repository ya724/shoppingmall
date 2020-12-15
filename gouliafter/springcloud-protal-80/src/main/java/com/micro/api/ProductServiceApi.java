package com.micro.api;

import com.micro.pojo.Product;
import com.rules.CustomRandomRule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.api
 * @CreateTime: 2020-11-18 17:32
 * @Description: Feign
 */
@FeignClient(value = "product-service",configuration = CustomRandomRule.class)
public interface ProductServiceApi {

    @GetMapping("/findProducts")
    public List<Product> findProducts();

    @GetMapping("/product_findProductsByCategory")
    public List<Product> findProductsByCategory(@RequestParam("product_category_id") Integer product_category_id);

    @RequestMapping("/product_findProductDetails")
    public Map<String,Object> findProductDetails(@RequestParam("product_id") Integer product_id);


}
