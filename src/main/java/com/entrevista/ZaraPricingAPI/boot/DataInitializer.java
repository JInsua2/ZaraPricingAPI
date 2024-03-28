package com.entrevista.ZaraPricingAPI.boot;


import com.entrevista.ZaraPricingAPI.app.domain.repository.ProductRepository;
import com.entrevista.ZaraPricingAPI.app.infrastructure.entities.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        loadPriceData();
    }

    private void loadPriceData() {
        productRepository.save( 1, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 1, 35455, 0, new BigDecimal("35.50"), "EUR");
        productRepository.save( 1, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), 2, 35455, 1, new BigDecimal("25.45"), "EUR");
        productRepository.save( 1, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), 3, 35455, 1, new BigDecimal("30.50"), "EUR");
        productRepository.save( 1, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 4, 35455, 1, new BigDecimal("38.95"), "EUR");
    }
}
