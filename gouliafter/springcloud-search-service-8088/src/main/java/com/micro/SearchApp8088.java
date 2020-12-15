package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端
public class SearchApp8088 {
    public static void main(String[] args) {
        SpringApplication.run(SearchApp8088.class,args);
    }
}
