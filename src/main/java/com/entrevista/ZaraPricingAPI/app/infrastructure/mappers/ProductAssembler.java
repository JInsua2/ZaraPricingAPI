package com.entrevista.ZaraPricingAPI.app.infrastructure.mappers;

import com.entrevista.ZaraPricingAPI.app.domain.entities.product.Product;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo.Price;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo.ProductID;
import com.entrevista.ZaraPricingAPI.app.domain.entities.brand.Brand;
import com.entrevista.ZaraPricingAPI.app.domain.entities.brand.vo.BrandID;
import com.entrevista.ZaraPricingAPI.app.infrastructure.entities.PriceEntity;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProductAssembler {

    public Product toProductList(List<PriceEntity> priceEntities) {
        if (priceEntities.isEmpty()) {
            throw new IllegalArgumentException("PriceEntity list is empty");
        }

        // Asumiendo que todos los PriceEntity tienen el mismo productID y brandID
        PriceEntity sample = priceEntities.get(0);
        ProductID productId = new ProductID((int) sample.getProductID());
        Brand brand = new Brand(new BrandID((int) sample.getBrandID()));

        // Crear un nuevo Product con el productID y brand obtenidos
        Product product = new Product(productId, brand);

        // Convertir cada PriceEntity a Price y agregarlo al Product
        Set<Price> prices = priceEntities.stream()
            .map(entity -> new Price(entity.getPrice(), entity.getCurrency(), entity.getStartDate(), entity.getEndDate(), entity.getPriority()))
            .collect(Collectors.toSet());

        prices.forEach(product::addPrice);

        return product;

    }

    private Price toPriceVo(PriceEntity entity) {
        return new Price(entity.getPrice(), entity.getCurrency(), entity.getStartDate(), entity.getEndDate(), entity.getPriority());
    }
}
