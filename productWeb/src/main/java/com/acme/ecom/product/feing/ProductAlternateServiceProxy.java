package com.acme.ecom.product.feing;

import org.springframework.cloud.openfeign.FeignClient;

import com.acme.ecom.product.feing.service.ProductService;

@FeignClient(primary = false, name = "product-alternate-proxy", url = "http://localhost:8179")
public interface ProductAlternateServiceProxy extends ProductService {

}
