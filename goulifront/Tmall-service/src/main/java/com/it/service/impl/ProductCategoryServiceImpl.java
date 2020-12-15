package com.it.service.impl;

import com.it.bean.PCategoryProperty;
import com.it.bean.ProductCategory;
import com.it.mapper.ProductCategoryMapper;
import com.it.service.PCategoryPropertyService;
import com.it.service.ProductCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    ProductCategoryMapper productCategoryMapper;

    @Resource
    PCategoryPropertyService pCategoryPropertyService;
    @Override
    public int GetAllCount(Map<String,Object> map) {
        return productCategoryMapper.GetAllCount(map);
    }

    @Override
    public List<ProductCategory> GetPageProductCategorys(Map<String, Object> map) {
        return productCategoryMapper.GetPageProductCategorys(map);
    }

    @Override
    public ProductCategory findById(Integer parent_id) {
        return productCategoryMapper.findById(parent_id);
    }
    @Override
    public int ProductCategoryAdd(ProductCategory productCategory) {
        return productCategoryMapper.ProductCategoryAdd(productCategory);
    }

    @Transactional
    @Override
    public int ProductCategoryAdd(ProductCategory productCategory, String[] propertyname) {


        int count = productCategoryMapper.ProductCategoryAdd(productCategory);
        if(count>0) {
            for (String name : propertyname) {
                PCategoryProperty pCategoryProperty=new PCategoryProperty();
                pCategoryProperty.setProperty_name(name);
                pCategoryProperty.setProperty_category_id(productCategory.getProduct_category_id());
                pCategoryPropertyService.addPCategoryProperty(pCategoryProperty);
            }
        }
        return count;
    }

    @Override
    public List<ProductCategory> GetAllCategorys(Integer parent_id) {
        return productCategoryMapper.GetAllCategorys(parent_id);
    }

}
