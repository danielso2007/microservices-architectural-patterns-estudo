package com.acme.ecom.product.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.acme.ecom.hateoas.model.ProductModel;
import com.acme.ecom.model.Product;
import com.acme.ecom.product.commons.lang.ProductConflictException;
import com.acme.ecom.product.commons.lang.ProductNotFoundException;
import com.acme.ecom.product.hateoas.assembers.ProductModelAssembler;
import com.acme.ecom.product.repository.ProductRepository;

@RestController
public class ProductRestController {
    private static final String ENDING = "Ending";

    private static final String START = "Start";

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductModelAssembler productModelAssembler;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductModel getProduct(@PathVariable("id") String id) {

        LOGGER.info(START);
        LOGGER.debug("Fetching Product with id: {}", id);

        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            String erroMsg = String.format("Product with id: %s not found", id);
            LOGGER.error(erroMsg);
            throw new ProductNotFoundException(erroMsg);
        }
        LOGGER.info(ENDING);

        return productModelAssembler.toModel(product.get());
    }

    // ------------------- Create a Product
    // --------------------------------------------------------
    @PostMapping(value = "/products")
    public ProductModel postProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {

        LOGGER.info(START);
        LOGGER.debug("Creating Product with code: {}", product.getCode());

        List<Product> products = productRepository.findByCode(product.getCode());

        if (!products.isEmpty()) {
            String erroMsg = String.format("A Product with code %s already exist", product.getCode());
            LOGGER.error(erroMsg);
            throw new ProductConflictException(erroMsg);
        }

        product.setCreator("none");
        product.setCreationAt(new Date());

        Product newProduct = productRepository.save(product);

        LOGGER.info(ENDING);

        return productModelAssembler.toModel(newProduct);
    }

    // ------------------- Update a Product
    // --------------------------------------------------------
    @PutMapping(value = "/products/{id}")
    public ProductModel updateProduct(@PathVariable("id") String id, @RequestBody Product product) {

        LOGGER.info(START);
        LOGGER.debug("Updating Product with id: {}", id);

        Optional<Product> currentProductOpt = productRepository.findById(id);

        if (currentProductOpt.isEmpty()) {
            String erroMsg = String.format("Product with id: %s not found", id);
            LOGGER.error(erroMsg);
            throw new ProductNotFoundException(erroMsg);
        }

        Product currentProduct = currentProductOpt.get();

        currentProduct.setName(product.getName());
        currentProduct.setCode(product.getCode());
        currentProduct.setTitle(product.getTitle());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setImgUrl(product.getImgUrl());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setProductCategoryName(product.getProductCategoryName());

        product.setUpdater("none");
        product.setUpdateAt(new Date());

        Product newProduct = productRepository.save(currentProduct);

        LOGGER.info(ENDING);
        return productModelAssembler.toModel(newProduct);
    }

    // ------------------- Retreive all Products
    // --------------------------------------------------------
    @GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CollectionModel<ProductModel> getAllProducts() {

        LOGGER.info(START);
        List<Product> products = productRepository.findAll();

        List<EntityModel<Product>> list = products.stream()
                .map(product -> EntityModel.of(product,
                        linkTo(methodOn(ProductRestController.class).getProduct(product.getId())).withSelfRel()))
                .collect(Collectors.toList());

        for (Product product : products) {
            list.add(EntityModel.of(product,
                    linkTo(methodOn(ProductRestController.class).getProduct(product.getId())).withSelfRel(),
                    linkTo(methodOn(ProductRestController.class).getAllProducts()).withRel("products")));
        }
        LOGGER.info(ENDING);
        return productModelAssembler.toCollectionModel(products);
    }

    // ------------------- Delete a Product
    // --------------------------------------------------------
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String id) {

        LOGGER.info(START);
        LOGGER.debug("Fetching & Deleting Product with id: {}", id);
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isEmpty()) {
            String erroMsg = String.format("Product with id: %s not found, hence not deleted", id);
            LOGGER.error(erroMsg);
            throw new ProductNotFoundException(erroMsg);
        }

        productRepository.deleteById(id);

        LOGGER.info(ENDING);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Products
    // --------------------------------------------------------
    @DeleteMapping(value = "/products")
    public ResponseEntity<Product> deleteAllProducts() {

        LOGGER.info(START);
        long count = productRepository.count();
        LOGGER.debug("Deleting {} products", count);
        productRepository.deleteAll();
        LOGGER.info(ENDING);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
