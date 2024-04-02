package com.phucnst.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckRepository extends JpaRepository<FraudCheck, Integer> {
    // JPA for Fraud
}
