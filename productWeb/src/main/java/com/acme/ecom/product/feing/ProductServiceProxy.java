package com.acme.ecom.product.feing;

import org.springframework.cloud.openfeign.FeignClient;

import com.acme.ecom.product.feing.service.ProductService;
import com.acme.ecom.product.hystrix.HystrixClientFallbackFactory;

//@FeignClient(name="product-proxy", url = "http://localhost:8180", fallback = ProductAlternateServerHystrix.class)
@FeignClient(primary = true, name="product-proxy", url = "http://localhost:8180", fallbackFactory = HystrixClientFallbackFactory.class)
public interface ProductServiceProxy extends ProductService {
}
