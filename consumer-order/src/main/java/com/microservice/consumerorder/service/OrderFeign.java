package com.microservice.consumerorder.service;

import com.microservice.consumerorder.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: springcloud
 * @Author: ZhangXiangQiang
 * @Create: 2021/3/16 15:02
 * @Description:
 */
@FeignClient(name = "microservice-provider-user")
//防止idea自动注入标红
@Component
public interface OrderFeign {
    @GetMapping(value = "/{id}")
    public Integer findUser(@PathVariable("id") int id);
    @PostMapping(value = "/addUser")
    public User addUser(User user);
}
