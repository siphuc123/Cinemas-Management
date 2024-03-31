package com.phucnst.customer;

public record CustomerRegistrationRequest(
        String customerFirstName,
        String customerLastName,
        String customerEmail) { }
