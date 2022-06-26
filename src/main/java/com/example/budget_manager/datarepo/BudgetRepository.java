package com.example.budget_manager.datarepo;

import com.example.budget_manager.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    @Query(value = "select sum(amount) as Incomes from budgets where budget_type = :budget_type", nativeQuery = true)
    Double sumOfBudgetType(String budget_type);
}
