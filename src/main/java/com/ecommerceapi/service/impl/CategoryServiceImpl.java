package com.ecommerceapi.service.impl;

import com.ecommerceapi.entity.Category;
import com.ecommerceapi.repository.CategoryRepository;
import com.ecommerceapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    @Override
    public String add(Category data) {
        try
        {
            repo.save(data);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public Category getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String delete(int id) {
        try
        {
            repo.deleteById(id);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }
    @Override
    public String update(Category data) {
        try
        {
            repo.save(data);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

}
