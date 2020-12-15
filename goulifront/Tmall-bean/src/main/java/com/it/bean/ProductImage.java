package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    private Integer productimage_id;
    private Integer productimage_type;
    private String productimage_src;
    private Integer productimage_product_id;

    public ProductImage(Integer productimage_type, String productimage_src, Integer productimage_product_id) {
        this.productimage_type = productimage_type;
        this.productimage_src = productimage_src;
        this.productimage_product_id = productimage_product_id;
    }
}
