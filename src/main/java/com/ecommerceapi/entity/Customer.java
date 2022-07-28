package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "Name", length = 100)
    public String name;

    @Column(name = "FullName", length = 100)
    public String fullName;

    @Column(name = "Email", length = 50)
    public String email;

    @Column(name = "Password", length = 20)
    public String password;

    @Column(name = "Phone", length = 15)
    public String phone;

    public boolean status;

}
