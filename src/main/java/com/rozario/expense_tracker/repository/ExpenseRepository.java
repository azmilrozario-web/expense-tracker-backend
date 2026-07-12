package com.rozario.expense_tracker.repository;

import com.rozario.expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    // Custom query - custom business logic
    List<Expense> findByCategoryId(Integer categoryId);

    // Write our own Query with @Query
    // because JPQL talks to Java entities. So we are using Expense class.
    // COALESCE(SUM(e.amount), 0) means If SUM returns NULL replace it with 0.
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e")
    BigDecimal getTotalExpenses();

    @Query("""
            SELECT COALESCE(SUM(e.amount),0)
            FROM Expense e
            WHERE e.categoryId = :categoryId
            """)
    BigDecimal getTotalByCategory(Integer categoryId);

    List<Expense> findByExpenseDate(LocalDate expenseDate);

    List<Expense> findByExpenseDateBetween(
            LocalDate startDate,
            LocalDate endDate);
//    automatically creates something similar to:
//    SELECT *
//    FROM expenses
//    WHERE expense_date
//    BETWEEN startDate
//    AND endDate;


}