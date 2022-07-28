package com.ecommerceapi.service;

import com.ecommerceapi.entity.Category;

import java.util.List;

public interface CategoryService {

    public String add(Category data);

    public List<Category> getAll();

    public Category getById(int id);

    public String delete(int id);

    public String update(Category data);
}
