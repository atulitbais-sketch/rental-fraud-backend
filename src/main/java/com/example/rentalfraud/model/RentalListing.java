package com.example.rentalfraud.model;

import jakarta.persistence.*;

@Entity
public class RentalListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private String ownerPhone;
    private String propertyAddress;
    private String city;
    private double rent;
    private double advanceAmount;
    private boolean visitAllowed;
    private int fraudScore;
    private String riskLevel;

    @Column(length = 1000)
    private String description;

    public Long getId() {
        return id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}