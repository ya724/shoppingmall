package com.micro.service.impl;

import com.micro.mapper.AddressMapper;
import com.micro.pojo.Address;
import com.micro.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.service.impl
 * @CreateTime: 2020-11-20 09:18
 * @Description: TODO
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    AddressMapper addressMapper;

    @Override
    public List<Address> findProvinces() {
        return addressMapper.findProvinces();
    }

    @Override
    public List<Address> findCitysOrTown(Integer address_regionId) {
        return addressMapper.findCitysOrTown(address_regionId);
    }
}
