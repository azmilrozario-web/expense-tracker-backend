package com.rozario.expense_tracker.controller;

import com.rozario.expense_tracker.model.Expense;
import com.rozario.expense_tracker.service.ExpenseServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseServiceInterface expenseService;

    public ExpenseController(ExpenseServiceInterface expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Integer id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable Integer id,
            @RequestBody Expense expense) {

        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Integer id) {
        expenseService.deleteExpense(id);
    }

    // Custom query - custom business logic
    @GetMapping("/category/{categoryId}")
    public List<Expense> getExpensesByCategory(
            @PathVariable Integer categoryId) {

        return expenseService.getExpensesByCategory(categoryId);
    }

    @GetMapping("/total")
    public BigDecimal getTotalExpenses() {
        return expenseService.getTotalExpenses();
    }

    @GetMapping("/category/{categoryId}/total")
    public BigDecimal getTotalByCategory(@PathVariable Integer categoryId) {
        return expenseService.getTotalByCategory(categoryId);
    }

    //Understanding The Path Variable
    //
    //Example URL:
    //
    //GET /expenses/date/2026-06-01
    //
    //Spring reads:
    //
    //2026-06-01
    //
    //and automatically converts it into:
    //
    //LocalDate
    //
    //which gets passed into:
    //
    //getExpensesByDate()
    @GetMapping("/date/{expenseDate}")
    public List<Expense> getExpensesByDate(
            @PathVariable LocalDate expenseDate) {

        return expenseService.getExpensesByDate(expenseDate);
    }

//    https://docs.google.com/document/d/1WUYQ6TrHTVOwNJu1Qgot73YuQ7K1Ulv7m9gO_rDRkWg/edit?tab=t.0
    @GetMapping("/date-range")
    public List<Expense> getExpensesBetweenDates(
            //Means parameters needs to be provided
            @RequestParam LocalDate start,

            @RequestParam LocalDate end) {

        return expenseService.getExpensesBetweenDates(
                start,
                end);
    }
}