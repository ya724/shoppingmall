package com.micro.controller;

import com.micro.api.ProductEsServiceClient;
import com.micro.api.ProductServiceApi;
import com.micro.pojo.Product;
import com.micro.utils.PageUtil;
import com.micro.utils.ResultCode;
import com.micro.utils.ResultCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ESController {
    @Autowired
    ProductServiceApi productServiceApi;

    @Autowired
    ProductEsServiceClient productEsServiceClient;

    @RequestMapping("/loadDataFromMysqlToEs")
    public ResultCommon loadDataFromMysqlToEs() {
        List<Product> products = productServiceApi.findProducts();
        for (Product product : products) {
            System.out.println(product);
        }

        productEsServiceClient.saveDocuments(products);
        return ResultCommon.success(ResultCode.SUCCESS,",把Mysql中的数据库加载导入到ES索引库中,成功!");
    }

    @RequestMapping("/es_deleteDocumentById")
    public ResultCommon deleteDocumentById(@RequestParam("id") Integer id){
        productEsServiceClient.deleteDocumentById(id);
        return ResultCommon.success(ResultCode.SUCCESS,"根据ID删除索引数据,成功");
    }

    @ResponseBody
    public PageUtil es_query1(String keywords){
        PageUtil pageUtil = productEsServiceClient.EsQuery1(keywords);
        return pageUtil;
    }

}
