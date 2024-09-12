package com.generixos.inventory.products.drugstore_management_products_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cost_history_entity")
public class CostHistoryEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id" , nullable = false, unique = true, length = 255)
    private String id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name= "currency", nullable = false, length = 255)
    private String currency;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name="tax_percentage", nullable = false)
    private double tax;

    @Column(name="discount_percentage", nullable = false)
    private double discount;

    @Column(name="total_cost", nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name="supplier_id", nullable = false)
    private SupplierEntity supplier;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

}