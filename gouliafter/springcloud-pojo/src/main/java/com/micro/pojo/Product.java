package com.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.pojo
 * @CreateTime: 2020-11-16 19:17
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "productindex",type = "product")
public class Product {

    @Id
    @Field(store = true,index = false,type = FieldType.Integer)
    private Integer product_id;
    @Field(store = true,analyzer = "ik_max_word",index = true,searchAnalyzer ="ik_max_word",type = FieldType.Text)
    private String product_name;
    @Field(store = true,analyzer = "ik_max_word",index = true,searchAnalyzer ="ik_max_word",type = FieldType.Text)
    private String product_title;
    @Field(store = true,index = false,type = FieldType.Double)
    private Double product_price;
    @Field(store = true,index = false,type = FieldType.Double)
    private Double product_sale_price;
    @Transient
    private String product_create_date;
    @Transient
    private Integer product_category_id;
    @Transient
    private Integer product_isEnabled;
    @Transient
    private Integer product_del;

    //扩展属性，商品图片
    @Field(store = true,analyzer = "ik_max_word",index = true,searchAnalyzer ="ik_max_word",type = FieldType.Text)
    private String smallimage;
}
