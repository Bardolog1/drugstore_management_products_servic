package com.generixos.inventory.products.drugstore_management_products_service.service;

import com.generixos.inventory.products.drugstore_management_products_service.model.ProductEntity;
import com.generixos.inventory.products.drugstore_management_products_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public ProductEntity getProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(ProductEntity product) {
        return productRepository.save(product);
    }

}
