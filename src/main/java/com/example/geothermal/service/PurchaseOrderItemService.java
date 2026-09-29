package com.example.geothermal.service;

import com.example.geothermal.entity.PurchaseOrderItem;
import com.example.geothermal.repository.PurchaseOrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderItemService {

    private final PurchaseOrderItemRepository purchaseOrderItemRepository;

    public PurchaseOrderItemService(
            PurchaseOrderItemRepository purchaseOrderItemRepository) {
        this.purchaseOrderItemRepository = purchaseOrderItemRepository;
    }

    public List<PurchaseOrderItem> getAllItems() {
        return purchaseOrderItemRepository.findAll();
    }

    public Optional<PurchaseOrderItem> getItemById(Integer id) {
        return purchaseOrderItemRepository.findById(id);
    }

    public PurchaseOrderItem saveItem(PurchaseOrderItem item) {
        return purchaseOrderItemRepository.save(item);
    }

    public void deleteItem(Integer id) {
        purchaseOrderItemRepository.deleteById(id);
    }
}