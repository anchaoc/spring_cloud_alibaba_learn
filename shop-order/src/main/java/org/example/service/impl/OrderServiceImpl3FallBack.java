package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderServiceImpl3对应的Throwable处理的类
 * @author anchao
 * @date 2020/11/6 14:49
 **/
@Slf4j
public class OrderServiceImpl3FallBack {
    //fallback
    //要求:
    //1 当前方法的返回值和参数要跟原方法一致
    //2 但是允许在参数列表的最后加入一个参数BlockException, 用来接收原方法中发生的异常
    public static String fallback(String name, Throwable e){
        log.error("触发了程序异常 Throwable:{0}",e);
        return "Throwable";
    }
}
