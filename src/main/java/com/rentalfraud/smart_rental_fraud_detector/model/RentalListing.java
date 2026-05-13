package com.rentalfraud.smart_rental_fraud_detector.model;

public class RentalListing {

    public String ownerName;
    public String ownerPhone;
    public String propertyAddress;
    public String city;

    public double rent;
    public double advanceAmount;

    public boolean visitAllowed;

    public String description;

    public int fraudScore;
    public String riskLevel;

    // Getters and Setters

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public boolean isVisitAllowed() {
        return visitAllowed;
    }

    public void setVisitAllowed(boolean visitAllowed) {
        this.visitAllowed = visitAllowed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFraudScore() {
        return fraudScore;
    }

    public void setFraudScore(int fraudScore) {
        this.fraudScore = fraudScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}