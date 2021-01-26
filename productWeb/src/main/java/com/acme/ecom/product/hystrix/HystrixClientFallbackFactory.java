package com.acme.ecom.product.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import com.acme.ecom.hateoas.model.ProductModel;
import com.acme.ecom.product.feing.ProductAlternateServiceProxy;
import com.acme.ecom.product.feing.ProductServiceProxy;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<ProductServiceProxy> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);
    
    @Autowired
    private ProductAlternateServiceProxy productAlternateServiceProxy;
    
    @Override
    public ProductServiceProxy create(Throwable cause) {
        return  new ProductServiceProxy() {
            @Override
            public CollectionModel<ProductModel> getAllProducts() {
                LOGGER.info("Delegating...");
                LOGGER.error(cause.getMessage());
                return productAlternateServiceProxy.getAllProducts();
            }

            @Override
            public ProductModel getProduct(String productId) {
                LOGGER.info("Delegating...");
                LOGGER.error(cause.getMessage());
                return productAlternateServiceProxy.getProduct(productId);
            }
       };
   }
}