package com.ecommerceapi.controller;

import com.ecommerceapi.entity.Order;
import com.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/fullData")
    public List<Order> getAll(){
        return orderService.getAll();
    }
    @GetMapping("/Orders")
    public List<Order> customersGetAll(int id){
        return orderService.customerGetAll(id);
    }
    @GetMapping("/orders/{id}")
    public Order getById(@PathVariable int id){
        return orderService.getById(id);
    }

    @PostMapping("/orders")
    public String create(@RequestBody Order data){
        return orderService.add(data);
    }

    @PutMapping("/orders")
    public String update(@RequestBody Order data){
        return orderService.update(data);
    }

}











