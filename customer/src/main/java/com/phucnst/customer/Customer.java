package com.phucnst.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Integer customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;

    //    getters and setters
}
