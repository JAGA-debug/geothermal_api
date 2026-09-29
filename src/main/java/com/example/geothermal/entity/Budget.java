package com.example.geothermal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "analytic_account_id", nullable = false)
    private AnalyticAccount analyticAccount;

    private Integer year;

    private String category;

    @Column(name = "planned_amount")
    private Double plannedAmount;

    private String notes;

    public Budget() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AnalyticAccount getAnalyticAccount() {
        return analyticAccount;
    }

    public void setAnalyticAccount(AnalyticAccount analyticAccount) {
        this.analyticAccount = analyticAccount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPlannedAmount() {
        return plannedAmount;
    }

    public void setPlannedAmount(Double plannedAmount) {
        this.plannedAmount = plannedAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}