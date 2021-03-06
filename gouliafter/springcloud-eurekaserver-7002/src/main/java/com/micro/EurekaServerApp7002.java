package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro
 * @CreateTime: 2020-11-17 16:37
 * @Description: TODO
 */
@EnableEurekaServer // 声明这个应用是一个EurekaServer
@SpringBootApplication
public class EurekaServerApp7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp7002.class, args);
    }
}
