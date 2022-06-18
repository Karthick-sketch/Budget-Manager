package com.example.budget_manager.datarepo;

import com.example.budget_manager.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BudgetRepo extends JpaRepository<Budget, Integer> {
    @Query(value = "select sum(amount) as Expenses from budgets where budget_type = 'expense'", nativeQuery = true)
    Double sumOfExpenses();

    @Query(value = "select sum(amount) as Incomes from budgets where budget_type = 'income'", nativeQuery = true)
    Double sumOfIncomes();
}
