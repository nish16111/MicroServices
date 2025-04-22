package com.sirwani.microservices.product.Controller;

import com.sirwani.microservices.product.Model.Product;
import com.sirwani.microservices.product.Service.ProductService;
import com.sirwani.microservices.product.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping("/get-all-products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> fetchAllProducts() {
        return productService.fetchAllProducts();
    }
}
