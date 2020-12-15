package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro
 * @CreateTime: 2020-11-17 11:14
 * @Description: TODO
 */
@EnableEurekaServer // 声明这个应用是一个EurekaServer
@SpringBootApplication
public class EurekaServerApp7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp7001.class, args);
    }
}
