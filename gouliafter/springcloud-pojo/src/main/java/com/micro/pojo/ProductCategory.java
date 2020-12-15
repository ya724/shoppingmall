package com.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.pojo
 * @CreateTime: 2020-11-19 10:51
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {

    private Integer product_category_id;
    private String iocn;
    private Integer parent_id=0;  //默认 值
    private String product_category_name;
    private Integer del;

}