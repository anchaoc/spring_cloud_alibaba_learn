package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Order;
import org.example.domain.Product;
import org.example.service.OrderService;
import org.example.service.ProductServiceFeign;
import org.example.service.impl.OrderServiceImpl3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController3 {

    int a =0;

    @Resource
    private OrderServiceImpl3 orderServiceImpl3;

    @RequestMapping("/order/message1")
    public String message1() {
        a++;
        if(a % 3 == 0){
            throw new RuntimeException();
        }
        //orderServiceImpl3.message();
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2() {
        orderServiceImpl3.message();
        return "message2";
    }

    @RequestMapping("/order/message3")
    @SentinelResource("message3")
    public String message3(String name, Integer age) {
        return "message3" + name + age;
    }
}
