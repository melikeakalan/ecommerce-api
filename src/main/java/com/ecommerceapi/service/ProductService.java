package com.ecommerceapi.service;

import com.ecommerceapi.entity.Product;

import java.util.List;

public interface ProductService {

    public String add(Product data);

    public List<Product> getAll();

    public Product getById(int id);

    public String delete(int id);

    public String update(Product data);
}
