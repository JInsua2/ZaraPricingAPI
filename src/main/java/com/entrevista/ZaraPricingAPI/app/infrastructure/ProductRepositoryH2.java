package com.entrevista.ZaraPricingAPI.app.infrastructure;

import com.entrevista.ZaraPricingAPI.app.domain.entities.product.Product;
import com.entrevista.ZaraPricingAPI.app.domain.repository.ProductRepository;
import com.entrevista.ZaraPricingAPI.app.infrastructure.entities.PriceEntity;
import com.entrevista.ZaraPricingAPI.app.infrastructure.mappers.ProductAssembler;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryH2 extends JpaRepository<PriceEntity, Integer>, ProductRepository {

    ProductAssembler productAssembler = new ProductAssembler();

    List<PriceEntity> findByProductIDAndBrandID(int productID, int brandID);

    @Override
    default Product getProduct(int productID, int brandID) {

        List<PriceEntity> priceEntities = findByProductIDAndBrandID(productID, brandID);
        return productAssembler.toProductList(priceEntities);
    }

    @Override
    default void save(int brandID, LocalDateTime startDate, LocalDateTime endDate, int priceList, int productID, int priority, BigDecimal price, String currency){
        save(new PriceEntity( brandID, startDate, endDate, priceList, productID, priority, price, currency));
    }

}
