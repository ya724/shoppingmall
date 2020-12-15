package com.it.service;

import com.it.bean.OrderGroup;
import com.it.bean.ProductOrder;

import java.util.List;
import java.util.Map;

public interface ProductOrderService {
    int GetAllCount(Map<String,Object> map);
    List<ProductOrder> GetPageProductOrders(Map<String,Object> map);
    ProductOrder GetAProductOrder(Integer productorder_id);

    Integer GetDealProductOrders();

    List<OrderGroup> findOrderGroups(String beginDate, String endDate);
}
