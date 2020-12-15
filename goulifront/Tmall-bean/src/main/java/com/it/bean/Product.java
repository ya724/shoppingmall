package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer product_id;
    private String product_name;
    private String product_title;
    private double product_price;
    private double product_sale_price;
    private String product_create_date;
    private Integer product_category_id;
    private Integer product_isEnabled;
    private Integer product_del;
}
