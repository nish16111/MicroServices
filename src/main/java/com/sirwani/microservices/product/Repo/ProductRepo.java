package com.sirwani.microservices.product.Repo;

import com.sirwani.microservices.product.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {

}
