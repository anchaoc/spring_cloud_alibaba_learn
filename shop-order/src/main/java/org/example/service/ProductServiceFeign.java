package org.example.service;

import org.example.domain.Product;
import org.example.service.fallback.ProductServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * //value用于指定调用nacos下哪个微服务
 * //fallback 指定当调用出现问题之后,要进入到哪个类中的同名方法之下执行备用逻辑
 * @author anchao
 * @date 2020/11/6 9:12
 **/
@FeignClient(value = "service-product",
//        fallback = ProductServiceFallBack.class,
        fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductServiceFeign {
    @RequestMapping("/product/{pid}")
    Product findById(@PathVariable Integer pid);
}
