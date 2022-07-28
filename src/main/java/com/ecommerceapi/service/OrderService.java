package com.ecommerceapi.service;

import com.ecommerceapi.entity.Order;

import java.util.List;

public interface OrderService {

    public String add(Order data);

    public List<Order> getAll();

    public List<Order> customerGetAll(int customerId);

    public Order getById(int id);

    public String update(Order data);

}
