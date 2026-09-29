package com.example.geothermal.service;

import com.example.geothermal.dto.BalanceSheetDTO;
import com.example.geothermal.dto.BudgetReportDTO;
import com.example.geothermal.dto.ProfitLossDTO;
import com.example.geothermal.entity.Account;
import com.example.geothermal.entity.Budget;
import com.example.geothermal.entity.JournalEntryLine;
import com.example.geothermal.repository.AccountRepository;
import com.example.geothermal.repository.BudgetRepository;
import com.example.geothermal.repository.JournalEntryLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final AccountRepository accountRepository;
    private final JournalEntryLineRepository journalEntryLineRepository;
    private final BudgetRepository budgetRepository;

    public ReportService(
            AccountRepository accountRepository,
            JournalEntryLineRepository journalEntryLineRepository,
            BudgetRepository budgetRepository) {

        this.accountRepository = accountRepository;
        this.journalEntryLineRepository = journalEntryLineRepository;
        this.budgetRepository = budgetRepository;
    }

    public BalanceSheetDTO getBalanceSheet() {

        double totalAssets = 0;
        double totalLiabilities = 0;
        double cashBank = 0;

        List<Account> accounts = accountRepository.findAll();

        for (Account account : accounts) {

            double balance = getAccountBalance(account);

            if ("ASSET".equalsIgnoreCase(account.getAccountType())) {
                totalAssets += balance;

                if ("Cash/Bank".equalsIgnoreCase(account.getAccountName())) {
                    cashBank = balance;
                }
            }

            if ("LIABILITY".equalsIgnoreCase(account.getAccountType())) {
                totalLiabilities += balance;
            }
        }

        return new BalanceSheetDTO(
                totalAssets,
                totalLiabilities,
                cashBank
        );
    }

    public ProfitLossDTO getProfitLoss() {

        double totalIncome = 0;
        double totalExpenses = 0;

        List<Account> accounts = accountRepository.findAll();

        for (Account account : accounts) {

            double balance = getAccountBalance(account);

            if ("INCOME".equalsIgnoreCase(account.getAccountType())) {
                totalIncome += balance;
            }

            if ("EXPENSE".equalsIgnoreCase(account.getAccountType())) {
                totalExpenses += balance;
            }
        }

        double netProfit = totalIncome - totalExpenses;

        return new ProfitLossDTO(
                totalIncome,
                totalExpenses,
                netProfit
        );
    }

    public BudgetReportDTO getBudgetReport() {

        double plannedAmount = 0;

        List<Budget> budgets = budgetRepository.findAll();

        for (Budget budget : budgets) {
            if (budget.getPlannedAmount() != null) {
                plannedAmount += budget.getPlannedAmount();
            }
        }

        /*
         * Actual amount will come from financial transactions.
         * Transaction automation will be added in the next step.
         */
        double actualAmount = 0;

        double remainingAmount = plannedAmount - actualAmount;

        return new BudgetReportDTO(
                plannedAmount,
                actualAmount,
                remainingAmount
        );
    }

    private double getAccountBalance(Account account) {

        double debit = 0;
        double credit = 0;

        List<JournalEntryLine> lines =
                journalEntryLineRepository.findAll();

        for (JournalEntryLine line : lines) {

            if (line.getAccount() != null
                    && line.getAccount().getId().equals(account.getId())) {

                if (line.getDebitAmount() != null) {
                    debit += line.getDebitAmount();
                }

                if (line.getCreditAmount() != null) {
                    credit += line.getCreditAmount();
                }
            }
        }

        String type = account.getAccountType();

        if ("ASSET".equalsIgnoreCase(type)
                || "EXPENSE".equalsIgnoreCase(type)) {

            return debit - credit;
        }

        return credit - debit;
    }
}