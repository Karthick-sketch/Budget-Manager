package com.example.budget_manager.controller;

import com.example.budget_manager.datarepo.BudgetRepo;
import com.example.budget_manager.model.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BudgetsController {
    @Autowired
    BudgetRepo budgetRepo;

    @GetMapping("/dashboard")
    public Map<String, Double> getBudgetCalculation() {
        Double expenses = budgetRepo.sumOfExpenses(), incomes = budgetRepo.sumOfIncomes();

        Map<String, Double> budgetCalculation = new HashMap<>();
        budgetCalculation.put("expenses", expenses);
        budgetCalculation.put("incomes", incomes);
        budgetCalculation.put("balance", incomes-expenses);

        return budgetCalculation;
    }

    @GetMapping("/budgets")
    public List<Budget> getBudgets() {
        return budgetRepo.findAll();
    }

    @GetMapping("/budget/{id}")
    public Optional<Budget> getBudgetById(@PathVariable("id") int id) {
        return budgetRepo.findById(id);
    }

    @PostMapping("/budget")
    public Budget createNewBudget(@RequestBody Budget budget) {
        budgetRepo.save(budget);
        return budget;
    }
}
