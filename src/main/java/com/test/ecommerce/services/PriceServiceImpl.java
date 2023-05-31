package com.test.ecommerce.services;

import com.test.ecommerce.mapper.PriceMapper;
import com.test.ecommerce.model.request.PriceRequest;
import com.test.ecommerce.model.entity.Prices;
import com.test.ecommerce.model.response.PriceResponse;
import com.test.ecommerce.repositories.PriceRepository;
import org.springframework.stereotype.Service;


@Service
public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;

    private final PriceMapper mapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper mapper){
        this.priceRepository = priceRepository;
        this.mapper = mapper;
    }

    public PriceResponse getPrice(PriceRequest priceReq){
        Iterable<Prices> prices = priceRepository.findPricesBy(
                priceReq.getBrandId(),
                priceReq.getProductId(),
                priceReq.getApplicationDate());

        PriceResponse pricesRequest = new PriceResponse();

        for(Prices price: prices){
            pricesRequest = mapper.mapToPriceResponse(price, priceReq);
            break;
        }
        return pricesRequest;
    }

}
