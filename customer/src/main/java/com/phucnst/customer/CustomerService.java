package com.phucnst.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .customerFirstName(customerRequest.customerFirstName())
                .customerLastName(customerRequest.customerLastName())
                .customerEmail(customerRequest.customerEmail())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                // before: "http://localhost:8081/api/v1/fraud-check/{customerId}"
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getCustomerId()
        );

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("THIS USER IS FRAUD");
        }
        // todo: send notification
    }
}
