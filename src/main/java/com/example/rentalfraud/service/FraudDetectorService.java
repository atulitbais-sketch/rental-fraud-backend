package com.example.rentalfraud.service;

import com.example.rentalfraud.model.RentalListing;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FraudDetectorService {

    public void analyze(RentalListing listing) {

        List<FraudRule> rules = Arrays.asList(
                l -> l.getRent() < 5000 ? 25 : 0,
                l -> l.getAdvanceAmount() > l.getRent() * 3 ? 25 : 0,
                l -> !l.isVisitAllowed() ? 20 : 0,
                l -> l.getOwnerPhone() == null || l.getOwnerPhone().trim().isEmpty() ? 20 : 0,
                l -> hasSuspiciousWords(l.getDescription()) ? 30 : 0
        );

        int score = rules.stream()
                .mapToInt(rule -> rule.check(listing))
                .sum();

        listing.setFraudScore(score);
        listing.setRiskLevel(getRiskLevel(score));
    }

    private boolean hasSuspiciousWords(String text) {
        if (text == null) return false;

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