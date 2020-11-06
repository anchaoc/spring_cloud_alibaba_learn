package org.example.service.impl;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * OrderServiceImpl3对应的BlockException处理的类
 * @author anchao
 * @date 2020/11/6 14:47
 **/
@Slf4j
public class OrderServiceImpl3BlockHandler {
    //blockHandler
    //要求:
    //1 当前方法的返回值和参数要跟原方法一致
    //2 但是允许在参数列表的最后加入一个参数BlockException, 用来接收原方法中发生的异常
    public static String blockHandler(String name, BlockException e){
        log.error("触发了sentinel异常 blockException:{0}",e);
        return "BlockException";
    }
}
