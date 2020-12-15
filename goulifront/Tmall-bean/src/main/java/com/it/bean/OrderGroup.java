package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGroup {
    private Date productorder_create_date; //订单下单时间
    private Integer productorder_status; //订单状态
    private Integer productOrder_count; //订单数量


    public String getProductOrderCreateDate() {
        if (productorder_create_date != null) {
            SimpleDateFormat time = new SimpleDateFormat("MM/dd", Locale.UK);
            return time.format(productorder_create_date);
        }
        return null;
    }

}
