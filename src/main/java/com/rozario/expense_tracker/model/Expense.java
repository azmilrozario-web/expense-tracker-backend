package com.rozario.expense_tracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;

    private String description;
    //money should use BigDecimal (decimal for more exact)
    private BigDecimal amount;

    private LocalDate expenseDate;

    private String notes;

    private Integer userId;

    private Integer categoryId;

}