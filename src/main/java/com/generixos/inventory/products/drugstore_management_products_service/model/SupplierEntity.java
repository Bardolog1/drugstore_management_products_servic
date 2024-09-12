package com.generixos.inventory.products.drugstore_management_products_service.model;

import com.generixos.inventory.products.drugstore_management_products_service.audit.AuditEntityListener;
import com.generixos.inventory.products.drugstore_management_products_service.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class, AuditEntityListener.class} )
@Table(name = "suppliers")
public class SupplierEntity extends AuditableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id" , nullable = false, unique = true, length = 255)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "phone", nullable = false, length = 255)
    private String phone;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "contact_person", nullable = false, length = 255)
    private String contactPerson;

    @Column(name = "contact_person_phone", nullable = false, length = 255)
    private String contactPersonPhone;


    @Column(name = "description", columnDefinition = "TEXT")
private String description;

    @ManyToMany(mappedBy = "suppliers", fetch = FetchType.EAGER)
    private List<ProductEntity> products;



}
