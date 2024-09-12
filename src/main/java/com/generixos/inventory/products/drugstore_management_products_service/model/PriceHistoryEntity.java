package com.generixos.inventory.products.drugstore_management_products_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "price_history_entity")
public class PriceHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id" , nullable = false, unique = true, length = 255)
    private String id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name= "currency", nullable = false, length = 255)
    private String currency;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;


    @Column(name = "date", nullable = false)
    private String date;

    @Column(name="price_type", nullable = false, length = 255)
    private String priceType;

}