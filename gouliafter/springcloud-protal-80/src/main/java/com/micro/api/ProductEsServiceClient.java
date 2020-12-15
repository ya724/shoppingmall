package com.micro.api;

import com.micro.pojo.Product;
import com.micro.utils.PageUtil;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "springcloud-search-service")
public interface ProductEsServiceClient {
    @RequestMapping("es-query1")
    public PageUtil EsQuery1(@RequestParam("keywords") String keywords) ;

    @RequestMapping("es-savedocument")
    public Product saveDocument(@RequestBody Product product);
    @RequestMapping("/es-savedocuments")
    public Iterable<Product> saveDocuments(@RequestBody List<Product> list);

    @RequestMapping("/es-getdocumentbyid")
    public Product getDocumentById(@RequestParam("id") Integer id);

    @RequestMapping("/es-updatedocumentbyid")
    public void updateDocumentById(@RequestBody Product product);

    @RequestMapping("/es-deletedocumentbyid")
    public void deleteDocumentById(@RequestParam("id") Integer id);

    @RequestMapping("/es-deletealldocument")
    public void deleteAllDocument();
}
