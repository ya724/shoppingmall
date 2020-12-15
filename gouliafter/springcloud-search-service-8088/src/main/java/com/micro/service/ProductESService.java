package com.micro.service;

import com.micro.pojo.Product;

import java.util.List;

public interface ProductESService {

    //新增文档
    public Product saveDocument(Product product);

    //批量新增
    public Iterable<Product> saveDocuments(List<Product> list);

    //根据ID查询文档
    public Product getDocumentById(Integer id);

    //根据ID更新
    public void updateDocumentById(Product product);

    //根据ID删除
    public void deleteDocumentById(Integer id);

    //全部删除
    public void deleteAllDocument();
}
