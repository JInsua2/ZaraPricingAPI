package com.entrevista.ZaraPricingAPI.app.domain.entities.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public record Price(
    Integer brandId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Integer priceList,
    Long productId,
    Integer priority,
    BigDecimal price,
    String currency
) {

    public Price {
        Objects.requireNonNull(brandId, "brandId must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(priceList, "priceList must not be null");
        Objects.requireNonNull(productId, "productId must not be null");
        Objects.requireNonNull(priority, "priority must not be null");
        Objects.requireNonNull(price, "price must not be null");
        Objects.requireNonNull(currency, "currency must not be null");
    }
}
