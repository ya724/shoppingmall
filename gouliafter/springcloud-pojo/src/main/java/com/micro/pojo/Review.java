package com.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Integer review_id;
    private String review_content;
    private String review_createdate;
    private Integer review_user_id;
    private Integer review_product_id;
    private Integer review_orderItem_id;
    private String review_name;
}
