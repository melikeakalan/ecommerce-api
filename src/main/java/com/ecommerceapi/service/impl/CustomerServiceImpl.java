package com.ecommerceapi.service.impl;

import com.ecommerceapi.entity.Customer;
import com.ecommerceapi.repository.CustomerRepository;
import com.ecommerceapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public String add(Customer data) {
        try
        {
            if(customerRepository.customerControl(data.email,data.phone) == null)
            {
                customerRepository.save(data);
                return "İşlem Başarılı Bir Şekilde Gerçekleşti";
            }
            else {
                return "Girdiğiniz Email adresine yada Telefon Numarasına sahip bir kullanıcı vardır.";
            }
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
    @Override
    public Customer getById(int Id) {
        return customerRepository.findById(Id).orElse(null);
    }
    @Override
    public String delete(int Id) {
        try
        {
            customerRepository.deleteById(Id);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    @Override
    public String update(Customer data) {
        try
        {
            customerRepository.save(data);
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
    public Customer login(String email, String password) {
        return customerRepository.login(email, password);
    }


}
