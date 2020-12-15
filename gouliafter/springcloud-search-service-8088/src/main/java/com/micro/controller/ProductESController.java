package com.micro.controller;

import com.micro.pojo.Product;
import com.micro.service.ProductESService;
import com.micro.utils.PageUtil;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductESController {

    @Autowired
    ProductESService productESService;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @RequestMapping("es-query1")
    public PageUtil EsQuery1(@RequestParam("keywords") String keywords) {
        int pageIndex = 1; //当前页码
        int pageSize = 4; //页码大小

        //构建一个查询对象
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                //设置查询条件，可以构建多个条件
                .withQuery(QueryBuilders.queryStringQuery(keywords).defaultField("product_name"))
                //设置分页的信息,页码从0开始计算
                .withPageable(PageRequest.of(pageIndex - 1, pageSize)).build();
        AggregatedPage<Product> productspage = elasticsearchTemplate.queryForPage(searchQuery, Product.class);
        System.out.println("当前页码:"+pageIndex);
        System.out.println("页面大小:"+pageSize);
        System.out.println("总页数:"+productspage.getTotalPages());
        System.out.println("总条数:"+productspage.getTotalElements());
        System.out.println("每页到的数据是:");
        List<Product> productspageContent = productspage.getContent();
        PageUtil pageUtil=new PageUtil(pageIndex,pageSize,productspage.getTotalElements(),productspageContent);
        return pageUtil;
    }

    @RequestMapping("es-savedocument")
    public Product saveDocument(@RequestBody Product product){
       return productESService.saveDocument(product);
    }

    @RequestMapping("/es-savedocuments")
    public Iterable<Product> saveDocuments(@RequestBody List<Product> list){
        return productESService.saveDocuments(list);
    }


    @RequestMapping("/es-getdocumentbyid")
    public Product getDocumentById(@RequestParam("id") Integer id){
        return productESService.getDocumentById(id);
    }

    @RequestMapping("/es-updatedocumentbyid")
    public void updateDocumentById(@RequestBody Product product){
        productESService.updateDocumentById(product);
    }

    @RequestMapping("/es-deletedocumentbyid")
    public void deleteDocumentById(@RequestParam("id") Integer id){
        productESService.deleteDocumentById(id);
    }

    @RequestMapping("/es-deletealldocument")
    public void deleteAllDocument(){
        productESService.deleteAllDocument();
    }
}
