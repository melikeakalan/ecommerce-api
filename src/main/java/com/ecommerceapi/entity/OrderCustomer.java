package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "order_customers")
@Entity
public class OrderCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int orderId;
    public String customerName;
    @Column(name = "City", length = 50)
    public String city;
    @Column(name = "District", length = 50)
    public String district;
    @Column(name = "FullAddresses", length = 350)
    public String fullAddress;
    @Column(name = "Phone", length = 15)
    public String phone;
    public boolean status;  //true:fatura adresi, false:teslimat adresi
}
