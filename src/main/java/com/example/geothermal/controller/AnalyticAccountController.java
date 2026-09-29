package com.example.geothermal.controller;

import com.example.geothermal.entity.AnalyticAccount;
import com.example.geothermal.service.AnalyticAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytic-accounts")
@CrossOrigin(origins = "*")
public class AnalyticAccountController {

    private final AnalyticAccountService analyticAccountService;

    public AnalyticAccountController(
            AnalyticAccountService analyticAccountService) {
        this.analyticAccountService = analyticAccountService;
    }

    @GetMapping
    public List<AnalyticAccount> getAllAnalyticAccounts() {
        return analyticAccountService.getAllAnalyticAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalyticAccount> getAnalyticAccountById(
            @PathVariable Integer id) {

        return analyticAccountService.getAnalyticAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AnalyticAccount createAnalyticAccount(
            @RequestBody AnalyticAccount analyticAccount) {

        return analyticAccountService.saveAnalyticAccount(analyticAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnalyticAccount> updateAnalyticAccount(
            @PathVariable Integer id,
            @RequestBody AnalyticAccount analyticAccount) {

        return analyticAccountService.getAnalyticAccountById(id)
                .map(existingAccount -> {
                    analyticAccount.setId(id);
                    return ResponseEntity.ok(
                            analyticAccountService.saveAnalyticAccount(
                                    analyticAccount));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalyticAccount(
            @PathVariable Integer id) {

        if (analyticAccountService
                .getAnalyticAccountById(id)
                .isPresent()) {

            analyticAccountService.deleteAnalyticAccount(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}