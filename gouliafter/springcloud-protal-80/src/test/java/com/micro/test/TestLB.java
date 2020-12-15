package com.micro.test;

import com.micro.ProtalApp80;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bruceliu
 * @create 2019-05-04 11:33
 * @description 负载均衡算法测试
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProtalApp80.class)
public class TestLB {

    //@Autowired
    RibbonLoadBalancerClient client;

    //@Test
    public void test1(){
        for (int i = 0; i <20 ; i++) {
            ServiceInstance instance = this.client.choose("PRODUCT-SERVICE");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }
}