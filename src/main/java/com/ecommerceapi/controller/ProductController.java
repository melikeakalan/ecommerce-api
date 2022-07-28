package com.ecommerceapi.controller;

import com.ecommerceapi.entity.Product;
import com.ecommerceapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/Products")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("/Products")
    public String create(@RequestBody Product data)
    {
        return productService.add(data);
    }

    @PutMapping("/Products")
    public String update(@RequestBody Product data)
    {
        return productService.update(data);
    }

    @DeleteMapping("/Products/{id}")
    public String delete(@PathVariable int id)
    {
        return productService.delete(id);
    }

}
