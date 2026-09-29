package com.example.geothermal.dto;

public class BudgetReportDTO {

    private Double plannedAmount;
    private Double actualAmount;
    private Double remainingAmount;

    public BudgetReportDTO() {
    }

    public BudgetReportDTO(
            Double plannedAmount,
            Double actualAmount,
            Double remainingAmount) {

        this.plannedAmount = plannedAmount;
        this.actualAmount = actualAmount;
        this.remainingAmount = remainingAmount;
    }

    public Double getPlannedAmount() {
        return plannedAmount;
    }

    public void setPlannedAmount(Double plannedAmount) {
        this.plannedAmount = plannedAmount;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
}