package com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(BigDecimal value,
                    String currency,
                    LocalDateTime startDate,
                    LocalDateTime endDate,
                    int priority) {

}
