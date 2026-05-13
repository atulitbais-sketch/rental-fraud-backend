package com.rentalfraud.smart_rental_fraud_detector.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/rentaldb",
                "root",
                "Atulitroot123"
            );

        } catch (Exception e) {

            System.out.println(e);

            return null;
        }
    }
}