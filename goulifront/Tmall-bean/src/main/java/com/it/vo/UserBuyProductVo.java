package com.it.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBuyProductVo {
    private String productimage_src;
    private Integer product_id;
    private String product_name;
    private Double product_price;
    private Double product_sale_price;
    private Double productorderitem_price; //购买钱数
    private Integer productorderitem_number; //购买钱数
    private String productorderitem_userMessage;
}
