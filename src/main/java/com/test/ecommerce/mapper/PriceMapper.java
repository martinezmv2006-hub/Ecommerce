package com.test.ecommerce.mapper;

import com.test.ecommerce.model.entity.Prices;
import com.test.ecommerce.model.request.PriceRequest;
import com.test.ecommerce.model.response.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {})
public interface PriceMapper extends EntityMapper<PriceResponse, Prices> {
    @Mapping(source = "price.productId", target = "productId")
    @Mapping(source = "priceReq.brandId", target = "brandId")
    @Mapping(source = "price.priceList", target = "price")
    @Mapping(source = "priceReq.applicationDate", target = "applicationDate")
    @Mapping(source = "price.price", target = "finalPrice")
    PriceResponse mapToPriceResponse(Prices price, PriceRequest priceReq);

}
