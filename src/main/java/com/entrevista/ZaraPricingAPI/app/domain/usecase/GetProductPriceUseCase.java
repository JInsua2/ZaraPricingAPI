package com.entrevista.ZaraPricingAPI.app.domain.usecase;

import com.entrevista.ZaraPricingAPI.app.domain.entities.product.Product;
import java.time.LocalDateTime;

public interface GetProductPriceUseCase {

    Product execute(LocalDateTime date, int productID, int brandID);
}
