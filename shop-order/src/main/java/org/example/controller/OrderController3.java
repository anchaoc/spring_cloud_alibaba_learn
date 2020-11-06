package org.example.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Order;
import org.example.domain.Product;
import org.example.service.OrderService;
import org.example.service.ProductServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController3 {

    @RequestMapping("/order/message1")
    public String message1() {
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }
}
