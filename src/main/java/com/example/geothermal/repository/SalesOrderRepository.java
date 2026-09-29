package com.example.geothermal.repository;

import com.example.geothermal.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository
        extends JpaRepository<SalesOrder, Integer> {
}