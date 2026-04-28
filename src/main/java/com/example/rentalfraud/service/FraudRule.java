package com.example.rentalfraud.service;

import com.example.rentalfraud.model.RentalListing;

@FunctionalInterface
public interface FraudRule {
    int check(RentalListing listing);
}