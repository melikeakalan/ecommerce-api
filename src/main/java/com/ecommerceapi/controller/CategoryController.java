package com.ecommerceapi.controller;

import com.ecommerceapi.entity.Category;
import com.ecommerceapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/Categories")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("/Categories")
    public String create(@RequestBody Category data) {

        return categoryService.add(data);
    }

    @PutMapping("/Categories")
    public String update(@RequestBody Category data) {
        return categoryService.update(data);
    }

    @DeleteMapping("/Categories/{id}")
    public String delete(@PathVariable int id) {

        return categoryService.delete(id);
    }
}
