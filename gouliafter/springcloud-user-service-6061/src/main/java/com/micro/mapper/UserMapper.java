package com.micro.mapper;

import com.micro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.mapper
 * @CreateTime: 2020-11-19 15:41
 * @Description: TODO
 */
@Mapper
public interface UserMapper {

    Integer register(User user);
}
