package com.entrevista.ZaraPricingAPI.app.domain.repository;

import com.entrevista.ZaraPricingAPI.app.domain.entities.product.Product;
import com.entrevista.ZaraPricingAPI.app.infrastructure.entities.PriceEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository {

    Product getProduct(int productID, int brandID);

    List<PriceEntity> findByProductIDAndBrandID(int productID, int brandID);



    void save(int brandID, LocalDateTime startDate, LocalDateTime endDate, int priceList, int productID, int priority, BigDecimal price, String currency);
}
