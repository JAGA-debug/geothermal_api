package com.example.geothermal.repository;

import com.example.geothermal.entity.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderItemRepository
        extends JpaRepository<PurchaseOrderItem, Integer> {
}