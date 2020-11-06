/*
package org.example.service.fallback;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Product;
import org.example.service.ProductServiceFeign;
import org.springframework.stereotype.Service;

*/
/**
 * ////这是一个容错类
 * ////它要求实现Feign所在接口,并实现里面的方法
 * ////当feign调用出现问题的时候,就会进入到当前类中同名方法中
 * @author anchao
 * @date 2020/11/6 15:51
 **//*

@Slf4j
@Service
public class ProductServiceFallBack implements ProductServiceFeign {
    @Override
    public Product findById(Integer pid) {
        log.error("product服务调用异常,进入熔断，pid:{}",pid);
        return new Product();
    }
}
*/
