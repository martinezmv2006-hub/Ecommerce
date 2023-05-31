package com.test.ecommerce.services;

import com.test.ecommerce.model.request.PriceRequest;
import com.test.ecommerce.model.response.PriceResponse;

public interface PriceService {
    PriceResponse getPrice(PriceRequest priceReq);

}
