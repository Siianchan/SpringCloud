package com.microservice.consumerorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/{id}")
    public Integer findOrder(@PathVariable int id) {
        System.out.println("OrderController:" + id);
        //microservice-provider-user
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, Integer.class);
    }
}
