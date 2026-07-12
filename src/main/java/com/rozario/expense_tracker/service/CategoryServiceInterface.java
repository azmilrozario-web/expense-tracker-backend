package com.rozario.expense_tracker.service;

import com.rozario.expense_tracker.model.Category;

import java.math.BigDecimal;
import java.util.List;

public interface CategoryServiceInterface {

    List<Category> getAllCategories();

    Category getCategoryById(Integer id);

    Category createCategory(Category category);

    void deleteCategory(Integer id);

    Category updateCategory(Integer id, Category category);

}