package com.microservice.consumerorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableFeignClients(basePackages = "com.microservice.consumerorder.service") 扫描和注册feign客户端bean定义
//加了@Component 可以不用添加包扫描
@EnableHystrix
    public class ConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }

}
