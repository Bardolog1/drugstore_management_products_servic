package com.generixos.inventory.products.drugstore_management_products_service.repository;

import com.generixos.inventory.products.drugstore_management_products_service.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {
}
