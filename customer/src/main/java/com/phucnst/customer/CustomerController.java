package com.phucnst.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerRepository repository;
    @Autowired
    private final CustomerService customerService;

    @PostMapping("/register")
    public void RegisterCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("new customer registered {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }

    // Chạy sau khi start up customer - tạo ra 1 user mới
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
