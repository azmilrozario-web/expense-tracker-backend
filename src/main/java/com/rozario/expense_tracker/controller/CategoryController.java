package com.rozario.expense_tracker.controller;

import com.rozario.expense_tracker.model.Category;
import com.rozario.expense_tracker.service.CategoryServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceInterface categoryService;


    public CategoryController(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(
            @PathVariable Integer id,
            @RequestBody Category category) {

        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

}