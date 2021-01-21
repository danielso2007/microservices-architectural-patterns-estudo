package com.acme.ecom.product.feing;

import org.springframework.cloud.openfeign.FeignClient;

import com.acme.ecom.product.feing.service.ProductService;

@FeignClient(name="product-proxy", url = "http://localhost:8180")
public interface ProductServiceProxy extends ProductService {
}
