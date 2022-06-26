package com.karthick.budget_manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "budgets")
public class Budget {
    @Id @GeneratedValue
    private int id;
    private double amount;
    private String explanation;
    private String category;
    private String budget_type;
    private Date date_added;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBudget_type() {
        return budget_type;
    }

    public void setBudget_type(String budget_type) {
        this.budget_type = budget_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBudget(Budget budget) {
        amount = budget.getAmount();
        explanation = budget.getExplanation();
        category = budget.getCategory();
        budget_type = budget.getBudget_type();
        date_added = budget.getDate_added();
    }
}
