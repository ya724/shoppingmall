package com.micro.controller;

import com.micro.pojo.Address;
import com.micro.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-20 09:18
 * @Description: TODO
 */
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    /**
     * 查询所有的省
     * @return
     */
    @RequestMapping("/address_findProvinces")
    public List<Address> findProvinces() {
        System.out.println(100/0);
        return addressService.findProvinces();
    }

    /**
     * 查询省下的市区
     * @param address_regionId
     * @return
     */
    @RequestMapping("/address_findCitysOrTown")
    public List<Address> findCitysOrTown(@RequestParam("address_regionId") Integer address_regionId) {
        return addressService.findCitysOrTown(address_regionId);
    }
}
