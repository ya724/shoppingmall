package com.micro;

import com.rules.CustomRandomRule;
import com.rules.MyLoadBalanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro
 * @CreateTime: 2020-11-16 19:51
 * @Description: TODO
 */
@EnableEurekaClient //开启客户端
@SpringBootApplication
@EnableFeignClients // 开启Feign功能
@EnableCircuitBreaker//对hystrixR熔断机制的支持
@EnableHystrixDashboard //开启仪表盘
//@RibbonClient(name = "product-service",configuration = CustomRandomRule.class)
public class ProtalApp80 {

    public static void main(String[] args) {
        SpringApplication.run(ProtalApp80.class,args);
    }
}
