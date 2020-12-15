package com.it;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("SpringBoot框架启动....");
        SpringApplication.run(App.class,args);
      /*  SpringApplication application=new SpringApplication(App.class);

        //关闭Banner，默认值是CONSOLE 控制台打印
       // application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);*/
    }
}
