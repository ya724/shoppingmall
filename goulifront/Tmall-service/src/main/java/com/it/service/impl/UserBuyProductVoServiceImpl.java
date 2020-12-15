package com.it.service.impl;

import com.it.mapper.UserBuyProductVoMapper;
import com.it.service.UserBuyProductVoService;
import com.it.vo.UserBuyProductVo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBuyProductVoServiceImpl implements UserBuyProductVoService {

    @Resource
    UserBuyProductVoMapper userBuyProductVoMapper;

    @Override
    public List<UserBuyProductVo> GetUserBuyProductVoById(Integer user_id) {
        return userBuyProductVoMapper.GetUserBuyProductVoById(user_id);
    }

    @Override
    public String GetProductImage( Integer product_id) {
        return userBuyProductVoMapper.GetProductImage(product_id);
    }

    @Override
    public UserBuyProductVo GetAUserBuyProductVo(Integer productorder_id) {
        return userBuyProductVoMapper.GetAUserBuyProductVo(productorder_id);
    }
}
