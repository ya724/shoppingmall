package com.micro.api;

import com.micro.pojo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.api
 * @CreateTime: 2020-11-20 09:20
 * @Description: TODO
 */
@FeignClient(value = "address-service")
public interface AddressClient {

    @RequestMapping("/address_findProvinces")
    public List<Address> findProvinces();


    @RequestMapping("/address_findCitysOrTown")
    public List<Address> findCitysOrTown(@RequestParam("address_regionId") Integer address_regionId);
}
