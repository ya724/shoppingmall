package com.rules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.rules
 * @CreateTime: 2020-11-18 16:50
 * @Description: TODO
 */
@Configuration
public class MyLoadBalanceRule {


    /**
     * @desc 自定义负载均衡规则，默认是轮询规则
     * @return
     */
    @Bean
    public IRule myRule(){
        //return new RandomRule(); // 改为随机算法规则
        return new RoundRobinRule(); // 轮询
    }

}
