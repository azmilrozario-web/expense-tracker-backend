package com.rozario.expense_tracker.service;

import com.rozario.expense_tracker.model.Category;
import com.rozario.expense_tracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

//Controller
//    ↓
//Service Interface
//    ↓
//Service Implementation
//    ↓
//Repository
//    ↓
//Database
//https://docs.google.com/document/d/1F2uohiWuMtXtFTiV_Gbfh23Y3WoOMce75y6HrhGsfNc/edit?tab=t.0

@Service
public class CategoryService implements CategoryServiceInterface{

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    Incorrect usage
//    @Override
//    public List<Category> getAllCategories() {
//        return List.of();
//    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAllByOrderByCategoryNameAsc();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer id, Category category) {

        Category existingCategory = getCategoryById(id);

        existingCategory.setCategoryName(category.getCategoryName());

        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

}
