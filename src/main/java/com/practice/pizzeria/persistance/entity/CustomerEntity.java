package com.practice.pizzeria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @Column(name = "id_customer", nullable = false)
    private Integer idCustomer;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String phoneNumber;

}
