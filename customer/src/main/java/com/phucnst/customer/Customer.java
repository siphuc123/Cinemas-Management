package com.phucnst.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    // Model for customer
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "customer_id_sequence"
    )
    private Integer customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;


    //    getters and setters
}
