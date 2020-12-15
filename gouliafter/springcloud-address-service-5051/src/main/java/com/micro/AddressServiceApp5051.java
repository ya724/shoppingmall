package com.micro;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.mirco
 * @CreateTime: 2020-11-20 09:12
 * @Description: TODO
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro
 * @CreateTime: 2020-11-19 15:40
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端
public class AddressServiceApp5051 {

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApp5051.class,args);
    }

}