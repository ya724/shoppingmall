package com.it.service;

import com.it.vo.UserBuyProductVo;

import java.util.List;

public interface UserBuyProductVoService {
   List<UserBuyProductVo> GetUserBuyProductVoById(Integer user_id);
   String GetProductImage(Integer product_id);
   UserBuyProductVo GetAUserBuyProductVo(Integer productorder_id);

}
