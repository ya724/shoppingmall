package com.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyBean {
    private Integer propertyvalue_id;
    private String propertyvalue_value;
    private Integer propertyvalue_property_id;
    private Integer propertyvalue_product_id;

}
