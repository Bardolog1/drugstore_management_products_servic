package com.generixos.inventory.products.drugstore_management_products_service.controller;


import com.generixos.inventory.products.drugstore_management_products_service.model.ProductEntity;
import com.generixos.inventory.products.drugstore_management_products_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<ProductEntity> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable("id") String id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/")
    public ProductEntity saveProduct(@RequestBody ProductEntity product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/")
    public ProductEntity updateProduct(@RequestBody ProductEntity product) {
        return productService.updateProduct(product);
    }

}
