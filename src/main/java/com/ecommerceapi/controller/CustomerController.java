package com.ecommerceapi.controller;

import com.ecommerceapi.entity.Customer;
import com.ecommerceapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @PostMapping("/customers")
    public String create(@RequestBody Customer customer)
    {
        return customerService.add(customer);
    }

    @PutMapping("/customers")
    public String update(@RequestBody Customer customer)
    {
        return customerService.update(customer);
    }

    @DeleteMapping("/customers/{id}")
    public String delete(@PathVariable int id)
    {
        return customerService.delete(id);
    }

    @PostMapping("/customers/Login")
    public Customer login(String email, String password)
    {
        return customerService.login(email, password);
    }

}
