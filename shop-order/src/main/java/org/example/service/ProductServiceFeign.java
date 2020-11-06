package org.example.service;

import org.example.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anchao
 * @date 2020/11/6 9:12
 **/
@FeignClient(value = "service-product")
public interface ProductServiceFeign {
    @RequestMapping("/product/{pid}")
    Product findById(@PathVariable Integer pid);
}
