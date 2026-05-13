package com.rentalfraud.smart_rental_fraud_detector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalfraud.smart_rental_fraud_detector.model.RentalListing;
import com.rentalfraud.smart_rental_fraud_detector.service.FraudDetector;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin(origins = "*")
public class RentalController {

    @Autowired
    private FraudDetector fraudDetector;

    @PostMapping("/analyze")
    public RentalListing analyzeRental(@RequestBody RentalListing rental) {

        fraudDetector.detectFraud(rental);

        return rental;
    }
}