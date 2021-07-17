package com.microservice.zuul.config;

import com.microservice.zuul.filter.FilterTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springcloud
 * @Author: ZhangXiangQiang
 * @Create: 2021/7/17 15:57
 * @Description:
 */
@Configuration
public class ConfigFilter {
    @Bean
    public FilterTest filterTest(){
        //配置过滤器
        return new FilterTest();
    }
}
