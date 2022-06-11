package com.example.budget_manager.datarepo;

import com.example.budget_manager.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepo extends JpaRepository<Budget, Integer> {
}
