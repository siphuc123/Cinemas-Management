package com.phucnst.customer;

import java.time.LocalDateTime;

public record FraudCheckResponse(
        Integer customerId,
        Boolean isFraudster,
        LocalDateTime createdDate
) { }
