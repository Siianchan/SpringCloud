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
//配置服务方提供的服务名称，并配置熔断之后调用的回退方法
@FeignClient(name = "microservice-provider-user",fallback = FeignFallBack.class)
//防止idea自动注入标红
@Component
public interface OrderFeign {
    
    @GetMapping(value = "/{id}")
    public Integer findUser(@PathVariable("id") int id);
    @PostMapping(value = "/addUser")
    public User addUser(User user);
}
@Component
class FeignFallBack implements OrderFeign{

    @Override
    public Integer findUser(int id) {
        System.out.println("调用findUser回退方法");
        return null;
    }

    @Override
    public User addUser(User user) {
        System.out.println("调用addUser回退方法");
        return null;
    }
}