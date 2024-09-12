package com.generixos.inventory.products.drugstore_management_products_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "ingredients_components")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsComponentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, length = 255)
    private String id;

    // Cantidad del producto en el compuesto
    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Producto que se usa como ingrediente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    // Componente al que pertenece este ingrediente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id", nullable = false)
    private ProductComponentEntity component;
}
