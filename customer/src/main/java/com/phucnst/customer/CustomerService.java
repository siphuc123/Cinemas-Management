package com.phucnst.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .customerFirstName(customerRequest.customerFirstName())
                .customerLastName(customerRequest.customerLastName())
                .customerEmail(customerRequest.customerEmail())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        // todo: store customer in database
    }
}
