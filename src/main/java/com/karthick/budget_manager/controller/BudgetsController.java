package com.karthick.budget_manager.controller;

import com.karthick.budget_manager.datarepo.BudgetRepository;
import com.karthick.budget_manager.dto.BudgetDto;
import com.karthick.budget_manager.model.Budget;
import com.karthick.budget_manager.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BudgetsController {
    @Autowired
    private BudgetRepository budgetRepo;

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/dashboard")
    public Map<String, Double> getBudgetCalculation() {
        Double expenses = budgetRepo.sumOfBudgetType("expense");
        Double incomes = budgetRepo.sumOfBudgetType("income");

        Map<String, Double> budgetCalculation = new HashMap<>();
        budgetCalculation.put("expenses", expenses);
        budgetCalculation.put("incomes", incomes);
        budgetCalculation.put("balance", incomes-expenses);

        return budgetCalculation;
    }

    @GetMapping("/budget/{user_id}")
    public List<BudgetDto> getBudgetsByUserId(@PathVariable("user_id") int user_id) {
        return budgetService.getBudgetsByUserId(user_id);
    }

    @PostMapping("/budget")
    public Budget createNewBudget(@RequestBody Budget budget) {
        budgetRepo.save(budget);
        return budget;
    }

    @PatchMapping("/budget/{id}")
    public boolean updateBudgetById(@PathVariable("id") int id, @RequestBody Budget newData) {
        Budget budget = budgetRepo.findById(id).orElse(null);
        if (budget != null) {
            budget.setBudget(newData);
            budgetRepo.save(budget);
            return true;
        }
        return false;
    }

    @DeleteMapping("/budget/{id}")
    public boolean deleteBudgetById(@PathVariable("id") int id) {
        Budget budget = budgetRepo.findById(id).orElse(null);
        if (budget != null) {
            budgetRepo.delete(budget);
            return true;
        }
        return false;
    }
}
