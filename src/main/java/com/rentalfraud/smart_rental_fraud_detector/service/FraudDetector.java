package com.rentalfraud.smart_rental_fraud_detector.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rentalfraud.smart_rental_fraud_detector.model.FraudRule;
import com.rentalfraud.smart_rental_fraud_detector.model.RentalListing;

@Service
public class FraudDetector {

    public boolean detectFraud(RentalListing listing) {

        List<FraudRule> rules = Arrays.asList(

            // Extremely low rent
            l -> l.rent < 3000 ? 40 :
                 l.rent < 5000 ? 25 :
                 l.rent < 7000 ? 10 : 0,

            // High advance demand
            l -> l.advanceAmount > l.rent * 6 ? 40 :
                 l.advanceAmount > l.rent * 4 ? 30 :
                 l.advanceAmount > l.rent * 2 ? 15 : 0,

            // Visit not allowed
            l -> !l.visitAllowed ? 30 : 0,

            // Missing phone
            l -> l.ownerPhone == null ||
                 l.ownerPhone.isBlank() ? 20 : 0,

            // Invalid phone number
            l -> l.ownerPhone != null &&
                 !l.ownerPhone.matches("\\d{10}") ? 25 : 0,

            // Very short description
            l -> l.description != null &&
                 l.description.trim().length() < 20 ? 15 : 0,

            // Suspicious words
            l -> suspiciousWordCount(l.description) * 10,

            // Missing address
            l -> l.propertyAddress == null ||
                 l.propertyAddress.isBlank() ? 20 : 0,

            // Missing city
            l -> l.city == null ||
                 l.city.isBlank() ? 15 : 0
        );

        int score = rules.stream()
                .mapToInt(rule -> rule.check(listing))
                .sum();

        if (score > 100) {
            score = 100;
        }

        listing.fraudScore = score;
        listing.riskLevel = getRiskLevel(score);

        if (score >= 80) {
            listing.message =
                "Likely scam. Do not send money before verifying the property and owner.";
        } else if (score >= 60) {
            listing.message =
                "Several fraud indicators detected. Verify documents and property details carefully.";
        } else if (score >= 35) {
            listing.message =
                "Some suspicious signs detected. Proceed with caution.";
        } else {
            listing.message =
                "No major fraud indicators detected.";
        }

        return score >= 60;
    }

    private int suspiciousWordCount(String text) {

        if (text == null)
            return 0;

        String lower = text.toLowerCase();

        String[] suspiciousWords = {
            "urgent payment",
            "pay now",
            "advance only",
            "no visit",
            "limited offer",
            "token amount",
            "booking amount",
            "instant booking",
            "transfer money",
            "deposit first",
            "cheap rent",
            "hurry",
            "whatsapp only",
            "guaranteed"
        };

        int count = 0;

        for (String word : suspiciousWords) {
            if (lower.contains(word)) {
                count++;
            }
        }

        return count;
    }

    private String getRiskLevel(int score) {

        if (score >= 80)
            return "Very High Risk";

        if (score >= 60)
            return "High Risk";

        if (score >= 35)
            return "Medium Risk";

        return "Low Risk";
    }
}