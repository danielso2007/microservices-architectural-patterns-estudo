package com.acme.ecom.product.hateoas.assembers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.acme.ecom.product.controller.ProductRestController;
import com.acme.ecom.product.hateoas.model.ProductModel;
import com.acme.ecom.product.model.Product;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {

    public ProductModelAssembler() {
        super(ProductRestController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(Product entity) {
        ProductModel model = instantiateModel(entity);

        model.add(linkTo(methodOn(ProductRestController.class).getProduct(entity.getId())).withSelfRel());
        model.add(linkTo(methodOn(ProductRestController.class).deleteProduct(entity.getId())).withRel("delete"));
        model.add(linkTo(methodOn(ProductRestController.class).getAllProducts()).withRel("products"));

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setCode(entity.getCode());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setImgUrl(entity.getImgUrl());
        model.setPrice(entity.getPrice());
        model.setProductCategoryName(entity.getProductCategoryName());
        model.setCreator(entity.getCreator());
        model.setCreationAt(entity.getCreationAt());
        model.setUpdater(entity.getUpdater());
        model.setUpdateAt(entity.getUpdateAt());
        
        return model;
    }

}
