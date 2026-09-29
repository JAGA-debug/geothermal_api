package com.example.geothermal.repository;

import com.example.geothermal.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository
        extends JpaRepository<PurchaseOrder, Integer> {
}