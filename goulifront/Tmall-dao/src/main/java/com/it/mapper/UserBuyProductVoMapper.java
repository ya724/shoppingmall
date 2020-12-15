package com.it.mapper;

import com.it.vo.UserBuyProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserBuyProductVoMapper {
    List<UserBuyProductVo> GetUserBuyProductVoById(Integer user_id);
    String GetProductImage(Integer product_id);
    UserBuyProductVo GetAUserBuyProductVo(Integer productorder_id);
}
