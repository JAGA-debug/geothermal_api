package com.example.geothermal.dto;

public class ProfitLossDTO {

    private Double totalIncome;
    private Double totalExpenses;
    private Double netProfit;

    public ProfitLossDTO() {
    }

    public ProfitLossDTO(
            Double totalIncome,
            Double totalExpenses,
            Double netProfit) {

        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netProfit = netProfit;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Double netProfit) {
        this.netProfit = netProfit;
    }
}