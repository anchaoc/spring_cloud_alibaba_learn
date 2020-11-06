package org.example.service.fallback;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Product;
import org.example.service.ProductServiceFeign;
import org.springframework.stereotype.Service;

/**
 * 这是容错类,他要求我们要是实现一个FallbackFactory<要为哪个接口产生容错类>
 * @author anchao
 * @date 2020/11/6 16:02
 **/
@Slf4j
@Service
public class ProductServiceFallbackFactory implements FallbackFactory<ProductServiceFeign> {
    @Override
    public ProductServiceFeign create(Throwable throwable) {
        return pid -> {
            log.error("throwable:{},pid:{}",throwable,pid);
            return new Product();
        };
    }
}
