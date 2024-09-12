package com.generixos.inventory.products.drugstore_management_products_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_components")
public class ProductComponentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, length = 255)
    private String id;

    // Nombre para el compuesto o combo
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    // Descripción del compuesto, kit, combo, etc.
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Precio del compuesto
    @Column(name = "component_price", nullable = false)
    private double componentPrice;

    // Lista de ingredientes que forman parte del compuesto
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "component")
    private List<IngredientsComponentEntity> ingredients;
}
