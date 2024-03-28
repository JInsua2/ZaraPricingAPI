package com.entrevista.ZaraPricingAPI.app.domain.entities.product;

import com.entrevista.ZaraPricingAPI.app.domain.entities.brand.Brand;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo.Price;
import com.entrevista.ZaraPricingAPI.app.domain.entities.product.vo.ProductID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

    @NonNull
    private final ProductID productID;

    @NonNull
    private final Brand brand;

    private Set<Price> prices = new HashSet<>();

    public void addPrice(Price price) {
        this.prices.add(price);
    }

    public Set<Price> getPrices() {
        return Collections.unmodifiableSet(prices);
    }
}
