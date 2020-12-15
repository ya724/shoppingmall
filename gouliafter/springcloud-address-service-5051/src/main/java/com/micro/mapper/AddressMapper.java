package com.micro.mapper;

import com.micro.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.mapper
 * @CreateTime: 2020-11-20 09:13
 * @Description: TODO
 */
@Mapper
public interface AddressMapper {

    List<Address> findProvinces();

    List<Address> findCitysOrTown(Integer address_regionId);
}
