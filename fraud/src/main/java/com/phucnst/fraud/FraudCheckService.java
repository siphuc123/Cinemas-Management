package com.phucnst.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    private final FraudCheckRepository fraudCheckRepository;

    // Constructor
    public FraudCheckService(FraudCheckRepository repository) {
        this.fraudCheckRepository = repository;
    }

    public boolean isFraudulent(Integer cusId) {
        // TODO: using third-party for this or make my own check
        fraudCheckRepository.save(
                FraudCheck.builder()
                        .customerId(cusId)
                        .isFraudster(false)
                        .createdDate(LocalDateTime.now())
                        .build()
        );
        // For particle microservices first ... I will update it later
        return false;
    }
}
