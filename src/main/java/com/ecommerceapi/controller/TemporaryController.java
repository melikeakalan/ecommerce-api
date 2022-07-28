package com.ecommerceapi.controller;

import com.ecommerceapi.entity.TemporaryBasket;
import com.ecommerceapi.service.TemporaryBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class TemporaryController {

    private final TemporaryBasketService temporaryBasketService;

    @GetMapping("/Temporary/Get/{id}")
    public List<TemporaryBasket> getAll(@PathVariable int id) {
        return temporaryBasketService.getAll(id);
    }

    @PostMapping("/Temporary")
    public String create(@RequestBody TemporaryBasket data) {
        return temporaryBasketService.add(data);
    }

    @PutMapping("/Temporary")
    public String update(int basketId, boolean status) {
        System.out.println(basketId);
        System.out.println(status);
        return temporaryBasketService.update(basketId, status);
    }

    @DeleteMapping("/Temporary/{id}")
    public String delete(@PathVariable int id) {
        return temporaryBasketService.delete(id);
    }


}
