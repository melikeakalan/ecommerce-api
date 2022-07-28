package com.ecommerceapi.service.impl;

import com.ecommerceapi.entity.Product;
import com.ecommerceapi.repository.ProductRepository;
import com.ecommerceapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Override
    public String add(Product data) {
        try
        {
            repo.save(data);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product getById(int Id) {
        return repo.findById(Id).orElse(null);
    }

    @Override
    public String delete(int Id) {
        try
        {
            repo.deleteById(Id);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String update(Product data) {
        try
        {
            repo.save(data);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

}
