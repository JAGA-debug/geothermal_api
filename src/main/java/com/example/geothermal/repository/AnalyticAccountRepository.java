package com.example.geothermal.repository;

import com.example.geothermal.entity.AnalyticAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticAccountRepository
        extends JpaRepository<AnalyticAccount, Integer> {
}
