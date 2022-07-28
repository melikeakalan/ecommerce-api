package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customer_addresses")
@Entity
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public int customerId;

    @Column(name = "addressName", length = 50)
    public String addressName;

    @Column(name = "City", length = 50)
    public String city;

    @Column(name = "District", length = 50)
    public String district;

    @Column(name = "FullAddress", length = 350)
    public String fullAddress;
}
