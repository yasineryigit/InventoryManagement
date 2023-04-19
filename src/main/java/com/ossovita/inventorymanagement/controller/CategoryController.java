package com.ossovita.inventorymanagement.controller;

import com.ossovita.inventorymanagement.entity.Category;
import com.ossovita.inventorymanagement.payload.request.CategoryRequest;
import com.ossovita.inventorymanagement.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping("/get-all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
