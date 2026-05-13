package com.rentalfraud.smart_rental_fraud_detector.model;

@FunctionalInterface
public interface FraudRule {
    int check(RentalListing listing);
}