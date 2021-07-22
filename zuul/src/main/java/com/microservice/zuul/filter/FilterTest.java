package com.microservice.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;


/**
 * @ProjectName: springcloud
 * @Author: ZhangXiangQiang
 * @Create: 2021/7/17 15:49
 * @Description:
 */
public class FilterTest extends ZuulFilter {

    public String filterType() {
        //执行器类型：pre -> route -> post -> error
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器的执行顺序，数据越小，优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true为执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("调用zuul拦截方法");
        return null;
    }
}
