package com.example.geothermal.controller;

import com.example.geothermal.entity.Budget;
import com.example.geothermal.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@CrossOrigin(origins = "*")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(
            @PathVariable Integer id) {

        return budgetService.getBudgetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetService.saveBudget(budget);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(
            @PathVariable Integer id,
            @RequestBody Budget budget) {

        return budgetService.getBudgetById(id)
                .map(existingBudget -> {
                    budget.setId(id);
                    return ResponseEntity.ok(
                            budgetService.saveBudget(budget));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(
            @PathVariable Integer id) {

        if (budgetService.getBudgetById(id).isPresent()) {
            budgetService.deleteBudget(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}