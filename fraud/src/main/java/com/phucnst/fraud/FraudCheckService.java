package com.phucnst.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckRepository fraudCheckRepository;

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
