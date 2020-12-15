package com.micro.service;

import com.micro.pojo.Address;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service
 * @CreateTime: 2020-11-20 09:17
 * @Description: TODO
 */
public interface AddressService {

    List<Address> findProvinces();

    List<Address> findCitysOrTown(Integer address_regionId);
}
