package com.micro.service.impl;

import com.micro.dao.ProductESDao;
import com.micro.pojo.Product;
import com.micro.service.ProductESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductESServiceImpl implements ProductESService {

    @Autowired
    ProductESDao productESDao;

    @Override
    public Product saveDocument(Product product) {
        return productESDao.save(product);
    }

    @Override
    public Iterable<Product> saveDocuments(List<Product> list) {
        return productESDao.saveAll(list);
    }

    @Override
    public Product getDocumentById(Integer id) {
        Optional<Product> optional = productESDao.findById(id);
        return optional.get();
    }

    @Override
    public void updateDocumentById(Product product) {
        productESDao.save(product);//如果对象上有ID 那么就更新 如果没有ID 就新增
    }

    @Override
    public void deleteDocumentById(Integer id) {
        productESDao.deleteById(id);
    }

    @Override
    public void deleteAllDocument() {
        productESDao.deleteAll();
    }
}
