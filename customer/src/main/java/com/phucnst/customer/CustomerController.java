package com.phucnst.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public void RegisterCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("new customer registered {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }

    /*
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List allCustomers = this.repository.findAll();
        log.info("Number of customers: " + allCustomers.size());

        Customer newCustomer = new Customer();
        newCustomer.setCustomerFirstName("Phuc");
        newCustomer.setCustomerLastName("Nguyen");
        newCustomer.setCustomerEmail("email@phuc.com");
        log.info("Saving new customer...");
        this.repository.save(newCustomer);

        allCustomers = this.repository.findAll();
        log.info("Number of customers: " + allCustomers.size());
    }
    */
}
