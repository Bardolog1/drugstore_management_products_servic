package com.generixos.inventory.products.drugstore_management_products_service.model;


import com.generixos.inventory.products.drugstore_management_products_service.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "barcodes")
public class BarcodesEntity extends AuditableEntity implements Serializable  {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 255)
    private String id;

    @Column(name = "ean", nullable = false, unique = true, length = 255)
    private String ean;

    @Column(name="is_Primary", nullable = false)
    private boolean isPrimary;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;




}
