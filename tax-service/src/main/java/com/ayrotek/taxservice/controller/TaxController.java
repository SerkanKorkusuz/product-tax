package com.ayrotek.taxservice.controller;

import com.ayrotek.taxservice.model.LogEvent;
import com.ayrotek.taxservice.model.Tax;
import com.ayrotek.taxservice.model.ProductTaxInfo;
import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Service
@RequiredArgsConstructor
@RestController
@RequestMapping("/tax-calculation")
public class TaxController {
    private final MongoCollection<Document> mongoCollection;
    Document document = new Document();

    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<Tax> calculate(@RequestBody ProductTaxInfo productTaxInfo, @RequestHeader Map<String, String> requestHeaders) {
        int taxCategory = productTaxInfo.getTaxCategory();
        double price = productTaxInfo.getPrice();
        double tax = switch (taxCategory) {
            case 0 -> price * 0.01;
            case 1 -> price * 0.08;
            case 2 -> price * 0.18;
            default -> 0;
        };
        Tax taxResult = new Tax(Double.parseDouble(new DecimalFormat("##.###").format(tax)));
        ResponseEntity<Tax> responseEntity = new ResponseEntity<>(taxResult, HttpStatus.OK);
        document.append(LogEvent.LOG_ID, responseEntity.hashCode());
        document.append(LogEvent.LOG_TIME, LocalDateTime.now());
        document.append(LogEvent.LOG_REQUEST_HEADERS, requestHeaders.toString());
        document.append(LogEvent.LOG_REQUEST_BODY, String.format("{\"code\": %s, \"tax_category\": %s, \"price\": %f}",
                productTaxInfo.getCode(), productTaxInfo.getTaxCategory(), productTaxInfo.getPrice()));
        document.append(LogEvent.LOG_STATUS_CODE, responseEntity.getStatusCodeValue());
        document.append(LogEvent.LOG_RESPONSE_HEADERS, responseEntity.getHeaders().toSingleValueMap());
        document.append(LogEvent.LOG_RESPONSE_BODY, String.format("{\"tax\": %f}", responseEntity.getBody().getTax()));
        try {
            mongoCollection.insertOne(document);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseEntity;
    }

}