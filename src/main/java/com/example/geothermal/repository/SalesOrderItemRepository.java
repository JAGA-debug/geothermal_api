package com.example.geothermal.repository;

import com.example.geothermal.entity.SalesOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderItemRepository
        extends JpaRepository<SalesOrderItem, Integer> {
}