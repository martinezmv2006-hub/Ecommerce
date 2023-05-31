package com.test.ecommerce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.ecommerce.model.request.PriceRequest;
import com.test.ecommerce.model.response.PriceResponse;
import com.test.ecommerce.services.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("product")
public class PriceController {

    private final Logger log = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService service;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get", consumes = "application/json; charset=utf-8")
    public ResponseEntity<String> getPrice(@Valid @RequestBody PriceRequest priceReq) {

        try {
            log.info("Get priceReq: {}", priceReq);

            PriceResponse priceRes = service.getPrice(priceReq);

            return ResponseEntity.status(200).body(new ObjectMapper().writeValueAsString(priceRes));
        } catch (Exception e) {
            log.error("Error while trying to get price: {}, with message: {}", e.getMessage(), priceReq);

            return ResponseEntity.status(500).body("Could not get price");
        }
    }
}
