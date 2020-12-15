package com.micro.dao;

import com.micro.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductESDao extends ElasticsearchRepository<Product, Integer> {
    //这个Dao里面什么可以不用写，已经有很多常用的方法，可以使用 因为在父接口中集成过来
}
