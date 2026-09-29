package com.example.geothermal.dto;

public class BalanceSheetDTO {

    private Double totalAssets;
    private Double totalLiabilities;
    private Double cashBank;

    public BalanceSheetDTO() {
    }

    public BalanceSheetDTO(
            Double totalAssets,
            Double totalLiabilities,
            Double cashBank) {

        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.cashBank = cashBank;
    }

    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(Double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public Double getCashBank() {
        return cashBank;
    }

    public void setCashBank(Double cashBank) {
        this.cashBank = cashBank;
    }
}