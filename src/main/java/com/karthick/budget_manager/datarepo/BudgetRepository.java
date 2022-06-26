package com.karthick.budget_manager.datarepo;

import com.karthick.budget_manager.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    @Query(value = "select sum(amount) as Total from budgets where budget_type = :budget_type", nativeQuery = true)
    Double sumOfBudgetType(String budget_type);

    @Query(value = "select * from budgets where user_id = :user_id", nativeQuery = true)
    List<Budget> findByUserId(int user_id);
}
