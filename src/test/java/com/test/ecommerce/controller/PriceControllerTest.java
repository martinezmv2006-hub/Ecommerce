package com.test.ecommerce.controller;

import com.test.ecommerce.data.DataPrice;
import com.test.ecommerce.model.request.PriceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceControllerTest {

    @Autowired
    private PriceController priceController;

    @Test
    void getPrice(){
        for (Map.Entry<PriceRequest, String> entry : DataPrice.getDataClient().entrySet()) {
            ResponseEntity<String> d = priceController.getPrice(entry.getKey());
            assertEquals(d.getStatusCode(), HttpStatus.OK);
            assertEquals(d.getBody(), entry.getValue());
        }
    }

}