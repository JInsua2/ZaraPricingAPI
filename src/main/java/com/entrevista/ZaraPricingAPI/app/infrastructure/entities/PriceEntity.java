package com.entrevista.ZaraPricingAPI.app.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BRAND_ID")
    private int brandID;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Column(name = "PRODUCT_ID")
    private int productID;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CURR")
    private String currency;

    public PriceEntity(int brandID, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, int productID, Integer priority, BigDecimal price, String currency) {
        this.brandID = brandID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productID = productID;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }
}
