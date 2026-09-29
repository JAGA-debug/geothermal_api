package com.example.geothermal.controller;

import com.example.geothermal.entity.Account;
import com.example.geothermal.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        return accountService.getAccountById(id).orElse(null);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
    }
}