package com.rentalfraud.smart_rental_fraud_detector.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rentalfraud.smart_rental_fraud_detector.model.FraudRule;
import com.rentalfraud.smart_rental_fraud_detector.model.RentalListing;

@Service
public class FraudDetector {

    public boolean detectFraud(RentalListing listing) {

       List<FraudRule> rules = Arrays.<FraudRule>asList(

            l -> l.rent < 5000 ? 25 : 0,

            l -> l.advanceAmount > l.rent * 3 ? 25 : 0,

            l -> !l.visitAllowed ? 20 : 0,

            l -> l.ownerPhone == null ||
                 l.ownerPhone.trim().isEmpty()
                 ? 20 : 0,

            l -> hasSuspiciousWords(l.description)
                 ? 30 : 0
        );

        int score = rules.stream()
                .mapToInt(rule -> rule.check(listing))
                .sum();

        listing.fraudScore = score;
        listing.riskLevel = getRiskLevel(score);

        return score >= 40;
    }

    private boolean hasSuspiciousWords(String text) {

        if (text == null)
            return false;

        String lower = text.toLowerCase();

        return lower.contains("urgent payment") ||
               lower.contains("pay now") ||
               lower.contains("no visit") ||
               lower.contains("advance only") ||
               lower.contains("limited offer");
    }

    private String getRiskLevel(int score) {

        if (score >= 70)
            return "High Risk";

        else if (score >= 40)
            return "Medium Risk";

        else
            return "Low Risk";
    }
}