package com.test.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceResponse {
    private Long productId;
    private Long brandId;
    private double price;
    private Date applicationDate;
    private double finalPrice;
}
