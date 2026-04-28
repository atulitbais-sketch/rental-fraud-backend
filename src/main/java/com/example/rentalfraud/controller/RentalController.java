package com.example.rentalfraud.controller;

import com.example.rentalfraud.model.RentalListing;
import com.example.rentalfraud.repository.RentalListingRepository;
import com.example.rentalfraud.service.FraudDetectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin(origins = "http://localhost:5173")
public class RentalController {

    private final RentalListingRepository repository;
    private final FraudDetectorService fraudDetectorService;

    public RentalController(RentalListingRepository repository,
                            FraudDetectorService fraudDetectorService) {
        this.repository = repository;
        this.fraudDetectorService = fraudDetectorService;
    }

    @PostMapping("/analyze")
    public RentalListing analyze(@RequestBody RentalListing listing) {
        fraudDetectorService.analyze(listing);
        return repository.save(listing);
    }

    @GetMapping
    public List<RentalListing> getAll() {
        return repository.findAll();
    }
}