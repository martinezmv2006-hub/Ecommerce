package com.test.ecommerce.repositories;

import com.test.ecommerce.model.entity.Prices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PriceRepository extends CrudRepository<Prices, Long> {

    @Query("SELECT p FROM Prices p WHERE p.id = :brandId " +
            "AND p.productId = :productId " +
            "AND (:appDate BETWEEN p.startDate AND p.endDate) " +
            "ORDER BY p.priority ASC")
    Iterable<Prices> findPricesBy(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("appDate") Date appDate
    );

}
