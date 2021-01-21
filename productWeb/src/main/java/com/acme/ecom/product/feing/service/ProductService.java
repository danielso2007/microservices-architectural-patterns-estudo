package com.acme.ecom.product.feing.service;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.acme.ecom.hateoas.model.ProductModel;

public interface ProductService {

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionModel<ProductModel> getAllProducts();

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductModel getProduct(@PathVariable("productId") String productId);

}