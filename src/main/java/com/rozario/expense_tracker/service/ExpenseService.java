package com.rozario.expense_tracker.service;

import com.rozario.expense_tracker.model.Expense;
import com.rozario.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService implements ExpenseServiceInterface{

    //private means:
    //
    //Only this class can use it.

    //final means:
    //
    //Once assigned, it can never point to another repository object.

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Integer id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Integer id, Expense expense) {

        Expense existingExpense = getExpenseById(id);

        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setExpenseDate(expense.getExpenseDate());
        existingExpense.setNotes(expense.getNotes());
        existingExpense.setUserId(expense.getUserId());
        existingExpense.setCategoryId(expense.getCategoryId());

        return expenseRepository.save(existingExpense);
    }

    @Override
    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }
    // Custom query - custom business logic
    @Override
    public List<Expense> getExpensesByCategory(Integer categoryId) {
        return expenseRepository.findByCategoryId(categoryId);
    }

    @Override
    public BigDecimal getTotalExpenses() {
        return expenseRepository.getTotalExpenses();
    }

    @Override
    public BigDecimal getTotalByCategory(Integer categoryId) {
        return expenseRepository.getTotalByCategory(categoryId);
    }

    @Override
    public List<Expense> getExpensesByDate(LocalDate expenseDate) {
        return expenseRepository.findByExpenseDate(expenseDate);
    }

    @Override
    public List<Expense> getExpensesBetweenDates(
            LocalDate startDate,
            LocalDate endDate) {

        return expenseRepository.findByExpenseDateBetween(
                startDate,
                endDate);
    }
}
