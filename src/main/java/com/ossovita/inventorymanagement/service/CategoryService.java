package com.ossovita.inventorymanagement.service;

import com.ossovita.inventorymanagement.entity.Category;
import com.ossovita.inventorymanagement.payload.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryRequest categoryRequest);

    List<Category> getAllCategories();
}
