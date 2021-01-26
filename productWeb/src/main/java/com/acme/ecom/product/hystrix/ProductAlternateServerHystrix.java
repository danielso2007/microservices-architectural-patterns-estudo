package com.acme.ecom.product.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import com.acme.ecom.hateoas.model.ProductModel;
import com.acme.ecom.product.feing.ProductAlternateServiceProxy;
import com.acme.ecom.product.feing.ProductServiceProxy;

@Component
public class ProductAlternateServerHystrix implements ProductServiceProxy {
    
    @Autowired
    private ProductAlternateServiceProxy productAlternateServiceProxy;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductAlternateServerHystrix.class);

    @Override
    public CollectionModel<ProductModel> getAllProducts() {
        LOGGER.info("Delegating...");
        return productAlternateServiceProxy.getAllProducts();
    }

    @Override
    public ProductModel getProduct(String productId) {
        LOGGER.info("Delegating...");
        return productAlternateServiceProxy.getProduct(productId);
    }
}
