package com.micro.controller;

import com.micro.api.AddressClient;
import com.micro.pojo.Address;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.controller
 * @CreateTime: 2020-11-20 09:21
 * @Description: TODO
 */
@RestController
public class AddressController {

    @Autowired
    AddressClient addressClient;

    /**
     * 01-查询所有的省 --- 存在问题
     * @return
     */
    @RequestMapping("/address_findProvinces")
    // 一旦调用服务方法失败，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "fallback")
    public List<Address> findProvinces(){
        return addressClient.findProvinces();
    }

    /**
     * findProvinces 方法的一个 备选方法，一旦findProvinces()调用不成功，那么自动会调用fallback()方法：进行一定容错
     * @return
     */
    public List<Address> fallback(){
        List<Address> addressList=new ArrayList<>();
        addressList.add(new Address("110000","北京市--B计划","110000"));
        return addressList;
    }


    @RequestMapping("/address_findCitysOrTown")
    public List<Address> findCitysOrTown(@RequestParam("address_regionId") Integer address_regionId){
        return addressClient.findCitysOrTown(address_regionId);
    }

}
