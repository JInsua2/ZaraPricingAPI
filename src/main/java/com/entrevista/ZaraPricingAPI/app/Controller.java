package com.entrevista.ZaraPricingAPI.app;

import com.entrevista.ZaraPricingAPI.app.domain.entities.product.Product;
import com.entrevista.ZaraPricingAPI.app.domain.usecase.GetProductPriceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/prices")
public class Controller {

    private final GetProductPriceUseCase getProductPriceUseCase;

    @Autowired
    public Controller(GetProductPriceUseCase getProductPriceUseCase) {
        this.getProductPriceUseCase = getProductPriceUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getPrice(
        @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
        @RequestParam("productID") int productID,
        @RequestParam("brandID") int brandID) {

        try {
            Product product = getProductPriceUseCase.execute(date, productID, brandID);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing the request: " + e.getMessage());
        }
    }
}
