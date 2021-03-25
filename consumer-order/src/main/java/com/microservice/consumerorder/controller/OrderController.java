package com.microservice.consumerorder.controller;

import com.microservice.consumerorder.model.User;
import com.microservice.consumerorder.service.OrderFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud
 * @Author: ZhangXiangQiang
 * @Create: 2021/3/10 17:47
 * @Description:
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderFeign orderFeign;
    @GetMapping("/{id}")
    //配置方法容错
    @HystrixCommand(fallbackMethod = "findOrderFallBack")
    public Integer findOrder(@PathVariable int id) {
        System.out.println("OrderController:" + id);
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, Integer.class);
    }

    public Integer findOrderFallBack( int id) {
        System.out.println("findOrderFallBack(hystrix容错调用方法):" + id);
        return 777;
    }

    @GetMapping("/test/{id}")
    public Integer findOrderFeign(@PathVariable int id) {
        //Feign调用
        System.out.println("OrderController(Feign):" + id);
        return this.orderFeign.findUser(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        //Feign调用
        System.out.println("OrderController:====="+user);
        User returnUser = this.orderFeign.addUser(user);
        returnUser.setUserAge(8002);
        returnUser.setUserName("OrderController");
        return returnUser;
    }

}
