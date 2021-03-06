package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {
    private Integer id;
    private Integer advertisement_category_id;
    private String title;
    private String url;
    private String pic;
    private String status;
    private Integer sort_order;
    private Integer del;
}
