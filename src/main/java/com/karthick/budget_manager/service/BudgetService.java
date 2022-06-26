package com.karthick.budget_manager.service;

import com.karthick.budget_manager.datarepo.BudgetRepository;
import com.karthick.budget_manager.dto.BudgetDto;
import com.karthick.budget_manager.model.Budget;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepo;

    public List<BudgetDto> getBudgetsByUserId(int user_id) {
        return budgetRepo.findByUserId(user_id).stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private BudgetDto convertEntityToDto(Budget budget) {
        return (new ModelMapper()).map(budget, BudgetDto.class);
    }
}
