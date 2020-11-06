package org.example.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author anchao
 * @date 2020/11/6 12:51
 **/
@Slf4j
@Service
public class OrderServiceImpl3 {
    int i =0;
    /**
     * 定义资源value指定资源名称
     *     //定义一个资源
     *     //定义当资源内部发生异常的时候的处理逻辑
     *     //blockHandler  定义当资源内部发生了BlockException应该进入的方法[捕获的是Sentinel定义的异常]
     *     //fallback      定义当资源内部发生了Throwable应该进入的方法
     */
    @SentinelResource(value = "message",
            blockHandlerClass = OrderServiceImpl3BlockHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderServiceImpl3FallBack.class,
            fallback = "fallback"
    )
    public String message(String name) {
        i++;
        if(i % 2 ==0){
            throw new RuntimeException();
        }
        return "message";
    }
}
