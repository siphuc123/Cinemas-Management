package com.phucnst.fraud;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId)
    {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulent(customerId);
        return new FraudCheckResponse(customerId, isFraudulentCustomer, LocalDateTime.now());
    }
}
