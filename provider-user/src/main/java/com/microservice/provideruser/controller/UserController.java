package com.microservice.provideruser.controller;

import com.microservice.provideruser.model.User;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/addUser", produces = {"application/json;charset=utf-8"})
    public User addUser(@RequestBody User user) {
        System.out.println("addUser:"+user);
        user.setUserAge(000);
        user.setUserName("addUser");
        return user;
    }

}
