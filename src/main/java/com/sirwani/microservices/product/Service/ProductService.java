package com.sirwani.microservices.product.Service;

import com.sirwani.microservices.product.Model.Product;
import com.sirwani.microservices.product.Repo.ProductRepo;
import com.sirwani.microservices.product.dto.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        log.info("Product added successfully");
        return productRepo.save(product);
//        return product;
    }

    public List<Product> fetchAllProducts() {
        return productRepo.findAll();
    }
}
