package com.rozario.expense_tracker.repository;

import com.rozario.expense_tracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

//What Does This Mean?
//
//Plain English first:
//
//        "Spring, please create all the database code for Category automatically."
//
//Without writing SQL.
//
//Without writing CRUD methods.
//
//Without writing JDBC.

//tells Spring:
//
//Category = table/entity
//
//        Integer = type of primary key

public interface CategoryRepository extends JpaRepository<Category, Integer> {


//    What You Automatically Get with this: extends JpaRepository<Category, Integer>
//
//    You haven't written any methods yet, but Spring creates:
//
//    findAll()
//
//    findById()
//
//    save()
//
//    deleteById()
//
//    deleteAll()
//
//for you.
List<Category> findAllByOrderByCategoryNameAsc();


}