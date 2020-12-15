package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    private Integer product_category_id;
    private String iocn;
    private Integer parent_id=0;
    private String product_category_name;
    private Integer del;
}
