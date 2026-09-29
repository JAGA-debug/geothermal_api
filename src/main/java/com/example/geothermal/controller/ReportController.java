package com.example.geothermal.controller;

import com.example.geothermal.dto.BalanceSheetDTO;
import com.example.geothermal.dto.BudgetReportDTO;
import com.example.geothermal.dto.ProfitLossDTO;
import com.example.geothermal.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/balance-sheet")
    public BalanceSheetDTO getBalanceSheet() {
        return reportService.getBalanceSheet();
    }

    @GetMapping("/profit-loss")
    public ProfitLossDTO getProfitLoss() {
        return reportService.getProfitLoss();
    }

    @GetMapping("/budget")
    public BudgetReportDTO getBudgetReport() {
        return reportService.getBudgetReport();
    }
}