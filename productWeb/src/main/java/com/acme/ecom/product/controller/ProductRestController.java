package com.acme.ecom.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acme.ecom.hateoas.model.ProductModel;
import com.acme.ecom.product.feing.ProductServiceProxy;
import com.acme.ecom.product.feing.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
public class ProductRestController implements ProductService{

    private ProductServiceProxy productServiceProxy;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    public ProductRestController(ProductServiceProxy productServiceProxy){
        this.productServiceProxy = productServiceProxy;
    }


    @Override
    @GetMapping(value = "/productsweb", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CollectionModel<ProductModel> getAllProducts() {
        LOGGER.info("ProductRestController Delegating...");
        return productServiceProxy.getAllProducts();
    }

    @Override
    @GetMapping(value = "/productsweb/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductModel getProduct(@PathVariable("productId") String productId) {
        LOGGER.info("ProductRestController Delegating...");
        return productServiceProxy.getProduct(productId);

    }
}