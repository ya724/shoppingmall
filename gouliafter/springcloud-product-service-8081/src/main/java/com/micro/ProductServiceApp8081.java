package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro
 * @CreateTime: 2020-11-16 19:26
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端
public class ProductServiceApp8081 {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApp8081.class,args);
    }
}
