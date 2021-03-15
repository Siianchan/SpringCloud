package com.microservice.provideruser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springcloud
 * @Author: ZhangXiangQiang
 * @Create: 2021/3/10 17:42
 * @Description:
 */
@RestController
public class UserController {
    @GetMapping("/{id}")
    public Integer findUser(@PathVariable int id) {
        System.out.println("UserController:"+id);
        return id * 10;
    }
}
