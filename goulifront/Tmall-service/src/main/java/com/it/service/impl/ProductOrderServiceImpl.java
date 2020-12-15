package com.it.service.impl;

import com.it.bean.OrderGroup;
import com.it.bean.Product;
import com.it.bean.ProductOrder;
import com.it.mapper.ProductOrderMapper;
import com.it.service.ProductOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Resource
    ProductOrderMapper productOrderMapper;
    @Override
    public int GetAllCount(Map<String, Object> map) {
        return productOrderMapper.GetAllCount(map);
    }

    @Override
    public List<ProductOrder> GetPageProductOrders(Map<String, Object> map) {
        return productOrderMapper.GetPageProductOrders(map);
    }

    @Override
    public ProductOrder GetAProductOrder(Integer productorder_id) {
        return productOrderMapper.GetAProductOrder(productorder_id);
    }

    @Override
    public Integer GetDealProductOrders() {
        return productOrderMapper.GetDealProductOrders();
    }

    @Override
    public List<OrderGroup> findOrderGroups(String beginDate, String endDate) {
        return productOrderMapper.findOrderGroups(beginDate,endDate);
    }
}
