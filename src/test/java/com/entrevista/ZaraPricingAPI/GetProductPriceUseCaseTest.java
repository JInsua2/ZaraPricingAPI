package com.entrevista.ZaraPricingAPI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.entrevista.ZaraPricingAPI.app.domain.entities.brand.Brand;
import com.entrevista.ZaraPricingAPI.app.domain.entities.brand.vo.BrandID;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.Product;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo.Price;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo.ProductID;
import com.entrevista.ZaraPricingAPI.app.domain.repository.ProductRepository;
import com.entrevista.ZaraPricingAPI.app.domain.usecase.GetProductPriceUseCase;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GetProductPriceUseCaseTest {

    @Mock
    private ProductRepository priceRepository;

    @InjectMocks
    private GetProductPriceUseCase getProductPriceUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        Set<Price> mockedPrices = Stream.of(
            new Price(new BigDecimal("35.50"), "EUR", LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 0),
            new Price(new BigDecimal("25.45"), "EUR", LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), 1),
            new Price(new BigDecimal("30.50"), "EUR", LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), 1),
            new Price(new BigDecimal("38.95"), "EUR", LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 1)
        ).collect(Collectors.toSet());

        Product product = new Product(new ProductID(35455), new Brand(new BrandID(1)), mockedPrices);

        given(priceRepository.getProduct(any(int.class), any(int.class)))
            .willReturn(product);
    }

    @Test
    public void getProductPriceUseCaseTest() {
    }

}
