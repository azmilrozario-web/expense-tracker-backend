package com.rozario.expense_tracker.service;

import com.rozario.expense_tracker.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseServiceInterface {

    List<Expense> getAllExpenses();

    Expense getExpenseById(Integer id);

    Expense createExpense(Expense expense);

    Expense updateExpense(Integer id, Expense expense);

    void deleteExpense(Integer id);
    // Custom query - custom business logic
    List<Expense> getExpensesByCategory(Integer categoryId);

    BigDecimal getTotalExpenses();

    BigDecimal getTotalByCategory(Integer categoryId);

    List<Expense> getExpensesByDate(LocalDate expenseDate);

    List<Expense> getExpensesBetweenDates(
            LocalDate startDate,
            LocalDate endDate);
}