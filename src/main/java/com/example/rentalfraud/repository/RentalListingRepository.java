package com.example.rentalfraud.repository;

import com.example.rentalfraud.model.RentalListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalListingRepository extends JpaRepository<RentalListing, Long> {
}