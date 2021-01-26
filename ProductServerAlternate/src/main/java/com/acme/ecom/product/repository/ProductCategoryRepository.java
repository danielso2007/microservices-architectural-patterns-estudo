package com.acme.ecom.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acme.ecom.model.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories", exported = true)
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {

}
