package com.test.ecommerce.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequest {

    @JsonProperty("applicationDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date applicationDate;

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("brandId")
    private Long brandId;

}
