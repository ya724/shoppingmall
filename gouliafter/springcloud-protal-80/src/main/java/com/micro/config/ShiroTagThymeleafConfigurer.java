package com.micro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ShiroTagThymeleafConfigurer {
    /**
     * 配置的是方言
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
