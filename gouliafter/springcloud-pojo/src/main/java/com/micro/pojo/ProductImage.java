package com.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.pojo
 * @CreateTime: 2020-11-17 10:26
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    private Integer productimage_id;
    private Integer productimage_type;
    private String productimage_src;
    private Integer productimage_product_id;

}
