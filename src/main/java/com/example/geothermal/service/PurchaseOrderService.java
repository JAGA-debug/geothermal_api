package com.example.geothermal.service;

import com.example.geothermal.entity.PurchaseOrder;
import com.example.geothermal.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(
            PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    public Optional<PurchaseOrder> getPurchaseOrderById(Integer id) {
        return purchaseOrderRepository.findById(id);
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public void deletePurchaseOrder(Integer id) {
        purchaseOrderRepository.deleteById(id);
    }
}