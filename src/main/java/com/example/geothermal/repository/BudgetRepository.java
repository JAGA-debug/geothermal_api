package com.example.geothermal.repository;

import com.example.geothermal.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
}