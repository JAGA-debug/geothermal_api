package com.example.geothermal.service;

import com.example.geothermal.entity.AnalyticAccount;
import com.example.geothermal.repository.AnalyticAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyticAccountService {

    private final AnalyticAccountRepository analyticAccountRepository;

    public AnalyticAccountService(
            AnalyticAccountRepository analyticAccountRepository) {
        this.analyticAccountRepository = analyticAccountRepository;
    }

    public List<AnalyticAccount> getAllAnalyticAccounts() {
        return analyticAccountRepository.findAll();
    }

    public Optional<AnalyticAccount> getAnalyticAccountById(Integer id) {
        return analyticAccountRepository.findById(id);
    }

    public AnalyticAccount saveAnalyticAccount(
            AnalyticAccount analyticAccount) {
        return analyticAccountRepository.save(analyticAccount);
    }

    public void deleteAnalyticAccount(Integer id) {
        analyticAccountRepository.deleteById(id);
    }
}