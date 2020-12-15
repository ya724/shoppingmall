package com.micro.controller;

import com.micro.pojo.Product;
import com.micro.pojo.ProductImage;
import com.micro.pojo.PropertyBean;
import com.micro.pojo.Review;
import com.micro.service.ProductImageService;
import com.micro.service.ProductService;
import com.micro.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-16 19:32
 * @Description: 接口 全部异步 JSON
 */
@RestController
@Api(value="商品controller",tags={"商品服务接口"})
public class ProductController {

   @Resource
   ProductService productService;
    @Resource
    ProductImageService productImageService;

    @Autowired
    ReviewService reviewService;

    /**
     * 01-对外暴露的接口
     * @return
     */
    @ApiOperation(value="查询所有的商品",notes="发送请求查询所有的商品数据，测试用的")
    @GetMapping("/findProducts")
    public List<Product> findProducts(){
        return productService.findProducts();
    }

    /**
     * 02-根据类名查询商品数据 最近的8个上架商品
     * @param
     * @return
     */
    @ApiOperation(value="根据类名查询商品数据 最近的8个上架商品",notes="根据类名查询商品数据 最近的8个上架商品")
    @GetMapping("/product_findProductsByCategory")
    public List<Product> findProductsByCategory(@RequestParam("product_category_id") Integer product_category_id){
        System.out.println("商品服务8082.....");
        List<Product> products = productService.findProductsByCategory(product_category_id);
        for (Product product : products) {
            List<ProductImage> productImages = productService.findProductSmallImage(product.getProduct_id());
            if(productImages.size()>0){
                product.setSmallimage(productImages.get(0).getProductimage_src());
            }
        }
        return products;
    }

    @RequestMapping("/product_findProductDetails")
    public Map<String,Object> findProductDetails(@RequestParam("product_id") Integer product_id) {
        Map<String,Object> map=new HashMap<>();

        Product product = productService.findById(product_id);
        List<PropertyBean> propertyBeans = productService.findPropertyBeans(product_id);
        Integer saleCount = productService.getSaleCount(product_id);
        List<ProductImage> productImages = productImageService.findProductImages(product_id);
        Integer reviewCount = reviewService.getReviewCount(product_id);
        List<Review> reviews = reviewService.findReviewsByProductId(product_id);
        map.put("product",product);
        map.put("propertyBeans",propertyBeans);
        map.put("productImages",productImages);
        map.put("reviews",reviews);
        map.put("reviewCount",reviewCount);
        map.put("saleCount",saleCount);
        return map;

    }

}
