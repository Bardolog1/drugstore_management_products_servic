package com.generixos.inventory.products.drugstore_management_products_service.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id" , nullable = false, unique = true, length = 255)
    private String id;

    @Column(name = "price", nullable = false)
    private BigDecimal cost;

    @Column(name = "tax_percentage", nullable = false)
    private BigDecimal tax;

    @Column(name = "discount_percentage", nullable = false)
    private BigDecimal discount;

    @Column(name = "utility_percentage", nullable = false)
    private BigDecimal utility;

    @Column(name = "total_price", nullable = false)
    private BigDecimal total;

    @Column(name= "currency", nullable = false, length = 255)
    private String currency;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "is_current", nullable = false)
    private boolean isCurrent;

    @Column(name = "is_inactive", nullable = false)
    private boolean isInactive;

    @Column(name="days_to_expire", nullable = false)
    private int daysToExpire;

    @Column(name="is_infinite", nullable = false)
    private boolean isInfinite;

    @Column(name="is_expired", nullable = false)
    private boolean isExpired;

    @Column(name="price_type", nullable = false, length = 255)
    private String priceType;


    public void calculateTotalPrice() {
        this.total = cost.add(cost.multiply(tax)).subtract(cost.multiply(discount)).add(cost.multiply(utility));
    }

    public void calculateIfExpired() {
        Date currentDate = new Date();
        long diff = currentDate.getTime() - startDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        if (isInfinite) {
            this.isExpired = false;
        } else if (diffDays > daysToExpire) {
            this.isExpired = true;
        } else {
            this.isExpired = false;
        }
    }


}



