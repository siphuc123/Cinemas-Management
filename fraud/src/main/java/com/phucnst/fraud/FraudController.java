package com.phucnst.fraud;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    @Autowired
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId)
    {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulent(customerId);
        log.info("fraud check request for customer {}", customerId);

        return new FraudCheckResponse(customerId, isFraudulentCustomer, LocalDateTime.now());
    }
}
