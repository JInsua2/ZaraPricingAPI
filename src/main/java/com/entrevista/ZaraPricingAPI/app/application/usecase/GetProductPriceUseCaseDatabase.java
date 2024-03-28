package com.entrevista.ZaraPricingAPI.app.application.usecase;

import com.entrevista.ZaraPricingAPI.app.domain.entities.product.Product;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo.Price;
import com.entrevista.ZaraPricingAPI.app.domain.repository.ProductRepository;
import com.entrevista.ZaraPricingAPI.app.domain.usecase.GetProductPriceUseCase;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetProductPriceUseCaseDatabase implements GetProductPriceUseCase {

    private ProductRepository productRepository;


    @Autowired
    public GetProductPriceUseCaseDatabase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(LocalDateTime date, int productID, int brandID) {
        Product product = productRepository.getProduct(productID, brandID);
        selectValidPriceForDate(product, date);
        return product;

    }

    public void selectValidPriceForDate(Product product, LocalDateTime date) {
        Set<Price> validPrices = product.getPrices().stream()
            .filter(price -> !date.isBefore(price.startDate()) && !date.isAfter(price.endDate()))
            .collect(Collectors.toSet());

        Optional<Price> mostRelevantPrice = validPrices.stream()
            .max(Comparator.comparingInt(Price::priority));

        Set<Price> newPrices = new HashSet<>();
        mostRelevantPrice.ifPresent(newPrices::add);

        product.setPrices(newPrices);
    }

}
