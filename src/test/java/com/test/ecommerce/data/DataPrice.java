package com.test.ecommerce.data;

import com.test.ecommerce.model.request.PriceRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DataPrice {
    public static Map<PriceRequest, String> getDataClient(){
        Map<PriceRequest, String> requestAndResponse = new HashMap<>();

        requestAndResponse.put(DataPrice.createPriceRequest("2020-06-14 10:00", 35455L, 1L),
                "{\"productId\":35455,\"brandId\":1,\"price\":1.0,\"applicationDate\":1592146800000,\"finalPrice\":35.5}");
        requestAndResponse.put(DataPrice.createPriceRequest("2020-06-14 16:0", 35455L, 1L),
                "{\"productId\":35455,\"brandId\":1,\"price\":1.0,\"applicationDate\":1592168400000,\"finalPrice\":35.5}");
        requestAndResponse.put(DataPrice.createPriceRequest("2020-06-14 21:00", 35455L, 1L),
                "{\"productId\":35455,\"brandId\":1,\"price\":1.0,\"applicationDate\":1592186400000,\"finalPrice\":35.5}");
        requestAndResponse.put(DataPrice.createPriceRequest("2020-06-15 10:00", 35455L, 1L),
                "{\"productId\":35455,\"brandId\":1,\"price\":1.0,\"applicationDate\":1592233200000,\"finalPrice\":35.5}");
        requestAndResponse.put(DataPrice.createPriceRequest("2020-06-16 21:00", 35455L, 1L),
                "{\"productId\":35455,\"brandId\":1,\"price\":1.0,\"applicationDate\":1592359200000,\"finalPrice\":35.5}");

        return requestAndResponse;
    }

    public static PriceRequest createPriceRequest(String date, Long productId, Long brandId){

        Date dates;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            dates = formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return PriceRequest.builder()
                .applicationDate(dates)
                .productId(productId)
                .brandId(brandId)
                .build();
    }
}
