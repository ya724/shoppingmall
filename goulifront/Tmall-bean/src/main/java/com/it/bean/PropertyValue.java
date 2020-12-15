package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValue {
    private Integer propertyvalue_id;
    private String propertyvalue_value;
    private Integer propertyvalue_property_id;
    private  Integer propertyvalue_product_id;
}
