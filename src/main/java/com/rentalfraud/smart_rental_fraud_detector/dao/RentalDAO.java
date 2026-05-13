package com.rentalfraud.smart_rental_fraud_detector.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rentalfraud.smart_rental_fraud_detector.model.RentalListing;

public class RentalDAO {

    public static void saveListing(RentalListing listing) {

        String sql = "INSERT INTO rental_listings " +
                "(owner_name, owner_phone, property_address, city, rent, advance_amount, visit_allowed, description, fraud_score, risk_level) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, listing.ownerName);
            ps.setString(2, listing.ownerPhone);
            ps.setString(3, listing.propertyAddress);
            ps.setString(4, listing.city);
            ps.setDouble(5, listing.rent);
            ps.setDouble(6, listing.advanceAmount);
            ps.setBoolean(7, listing.visitAllowed);
            ps.setString(8, listing.description);
            ps.setInt(9, listing.fraudScore);
            ps.setString(10, listing.riskLevel);

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Database Error: " + e.getMessage());
        }
    }
}