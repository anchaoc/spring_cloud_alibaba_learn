package org.example.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Order;
import org.example.domain.Product;
import org.example.service.OrderService;
import org.example.service.ProductServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Resource
    private ProductServiceFeign productService;


    /**
     * 5.下单,使用feign调用
     */
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        Product product = productService.findById(pid);
        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        //orderService.createOrder(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        return order;
    }


    /**
     * 4.下单,ribbon负载均衡
     */
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//        Product product =
//                restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//        return order;
//    }

    /**
     * 3.下单,自定义负载均衡Random
     */
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("service-product");
//        if (CollectionUtils.isEmpty(instanceList)) {
//            throw new RuntimeException("instanceList is empty");
//        }
//        int nextInt = new Random().nextInt(instanceList.size());
//        ServiceInstance instance = instanceList.get(nextInt);
//        Product product =
//                restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//        return order;
//    }



//    /**
//     * 2.下单,通过discoveryClient获取域名，restTemplate调用
//     */
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("service-product");
//        if (CollectionUtils.isEmpty(instanceList)) {
//            throw new RuntimeException("instanceList is empty");
//        }
//        ServiceInstance instance = instanceList.get(0);
//        Product product =
//                restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//        return order;
//    }


    /**
     * 1.普通下单,通过restTemplate调用
     */
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//        Product product =
//                restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//        return order;
//    }

}
