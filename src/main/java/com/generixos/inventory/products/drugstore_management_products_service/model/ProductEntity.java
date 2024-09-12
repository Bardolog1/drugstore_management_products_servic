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
@EntityListeners({AuditingEntityListener.class, AuditEntityListener.class})
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, length = 255)
    private String id;

    @Column(name = "sku", nullable = false, unique = true, length = 255)
    private String sku;

    @Column(name = "name", nullable = false, length = 255)
    private String name;


    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name="labels", nullable = false, columnDefinition = "JSON")
    private String labels;

    @Column(name="location_store", nullable = false, columnDefinition = "JSON")
    private String locationStore;

    @Column(name="manage_inventory", nullable = false)
    private boolean manageInventory;

    @Column(name="has_references", nullable = false)
    private boolean hasReferences;

    @Column(name="sales_without_stock", nullable = false)
    private boolean salesWithoutStock;

    @Column(name="is_composed", nullable = false)
    private boolean isComposed;

    @Column(name="canAddToComposed", nullable = false)
    private boolean canAddToComposed;

    @Column(name="is_service", nullable = false)
    private boolean isService;

    @Column(name="has_children", nullable = false)
    private boolean hasChildren;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<BarcodesEntity> barcodes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<SupplierEntity> suppliers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<PriceEntity> prices;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<PriceHistoryEntity> priceHistory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<CostHistoryEntity> costHistory;


    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand=" + brand +
                ", active=" + active +
                ", labels='" + labels + '\'' +
                ", locationStore='" + locationStore + '\'' +
                ", manageInventory=" + manageInventory +
                ", hasReferences=" + hasReferences +
                ", salesWithoutStock=" + salesWithoutStock +
                ", isComposed=" + isComposed +
                ", canAddToComposed=" + canAddToComposed +
                ", isService=" + isService +
                ", hasChildren=" + hasChildren +
                ", barcodes=" + barcodes +
                ", suppliers=" + suppliers +
                ", category=" + category +
                ", prices=" + prices +
                ", priceHistory=" + priceHistory +
                ", costHistory=" + costHistory +
                '}';
    }
}
