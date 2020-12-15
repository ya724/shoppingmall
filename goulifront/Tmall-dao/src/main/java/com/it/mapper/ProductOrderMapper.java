package com.it.mapper;

import com.it.bean.OrderGroup;
import com.it.bean.ProductOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductOrderMapper {

    int GetAllCount(Map<String,Object> map);
    List<ProductOrder> GetPageProductOrders(Map<String,Object> map);
    ProductOrder GetAProductOrder(Integer productorder_id);

    Integer GetDealProductOrders();


    List<OrderGroup> findOrderGroups(String beginDate, String endDate);
}
