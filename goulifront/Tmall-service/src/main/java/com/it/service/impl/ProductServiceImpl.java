package com.it.service.impl;

import com.it.bean.Product;
import com.it.bean.ProductImage;
import com.it.bean.PropertyValue;
import com.it.mapper.PCategoryPropertyMapper;
import com.it.mapper.ProductImageMapper;
import com.it.mapper.ProductMapper;
import com.it.mapper.PropertyValueMapper;
import com.it.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Resource
    ProductImageMapper productImageMapper;

    @Resource
    PropertyValueMapper propertyValueMapper;
    @Override
    public int GetAllCount(Map<String, Object> map) {
       return productMapper.GetAllCount(map);
    }

    @Override
    public List<Product> GetPageProducts(Map<String, Object> map) {
        return productMapper.GetPageProducts(map);
    }

    @Override
    public int ProductAdd(Product product) {
        return productMapper.ProductAdd(product);
    }

    @Transactional
    @Override
    public int ProductAdd(Product product, String[] singleImagesArray, String[] detailsImagesArray, Integer[] propertyvalue_property_id, String[] propertyvalue_value) {
        int count = productMapper.ProductAdd(product);
        System.out.println("商品新增成功之后的注解是:"+product.getProduct_id());
        //规格表
        for (int i = 0; i < propertyvalue_property_id.length; i++) {
            PropertyValue propertyValue=new PropertyValue();
            propertyValue.setPropertyvalue_value(propertyvalue_value[i]);
            propertyValue.setPropertyvalue_product_id(product.getProduct_id());
            propertyValue.setPropertyvalue_property_id(product.getProduct_category_id());
            propertyValueMapper.PropertyValueAdd(propertyValue);
        }
        //概述图
        for (int i = 0; i < singleImagesArray.length; i++) {
            ProductImage productImage=new ProductImage();
            productImage.setProductimage_src(singleImagesArray[i]);
            productImage.setProductimage_type(0);
            productImage.setProductimage_product_id(product.getProduct_id());
            productImageMapper.ProductImageAdd(productImage);
        }

        //概详细图
        for (int i = 0; i <detailsImagesArray.length ; i++) {
            ProductImage productImage=new ProductImage(1,detailsImagesArray[i],product.getProduct_id());
            productImageMapper.ProductImageAdd(productImage);
        }



        return count;
    }

    @Override
    public int GetOnlineProducts() {
        return productMapper.GetOnlineProducts();
    }
}
