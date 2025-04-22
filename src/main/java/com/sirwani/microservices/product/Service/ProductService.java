package com.sirwani.microservices.product.Service;

import com.sirwani.microservices.product.Model.Product;
import com.sirwani.microservices.product.Repo.ProductRepo;
import com.sirwani.microservices.product.dto.ProductRequest;
import com.sirwani.microservices.product.dto.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        log.info("Product added successfully!");
        productRepo.save(product);
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }

    public List<ProductResponse> fetchAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()))
                .toList();
    }
}
