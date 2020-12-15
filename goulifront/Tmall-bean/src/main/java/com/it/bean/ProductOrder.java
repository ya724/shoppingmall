package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    private Integer productorder_id;
    private String productorder_code;
    private String productorder_address;
    private String productorder_detail_address;
    private String productorder_post;
    private String productorder_receiver;
    private String productorder_mobile;
    private String productorder_create_date;
    private String productorder_pay_date;
    private String productorder_delivery_date;
    private String productorder_confirm_date;
    private Integer productorder_status;
    private Integer productorder_user_id;

}
