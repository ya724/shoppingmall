package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PCategoryProperty {
    private  Integer property_id;
    private String property_name;
    private Integer  property_category_id;
}
