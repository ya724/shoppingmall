package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro
 * @CreateTime: 2020-11-19 09:40
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端
public class AdvertisementServiceApp9091 {

    public static void main(String[] args) {
        SpringApplication.run(AdvertisementServiceApp9091.class,args);
    }

}
