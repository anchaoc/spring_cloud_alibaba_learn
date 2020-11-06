package org.example.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author anchao
 * @date 2020/11/6 12:51
 **/
@Service
public class OrderServiceImpl3 {
    /**
     * 定义资源value指定资源名称
     */
    @SentinelResource(value = "message")
    public String message() {
        return "message";
    }
}
