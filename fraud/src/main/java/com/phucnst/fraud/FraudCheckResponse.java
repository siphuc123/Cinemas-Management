package com.phucnst.fraud;

import java.time.LocalDateTime;

public record FraudCheckResponse(
        Integer customerId,
        Boolean isFraudster,
        LocalDateTime createdDate
) { }
