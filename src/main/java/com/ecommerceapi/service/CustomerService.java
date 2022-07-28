package com.ecommerceapi.service;

import com.ecommerceapi.entity.Customer;

import java.util.List;

public interface CustomerService {

    public String add(Customer data);

    public List<Customer> getAll();

    public Customer getById(int id);

    public String delete(int id);

    public String update(Customer data);

    public Customer login(String email, String password);


}
