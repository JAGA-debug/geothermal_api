package com.example.geothermal.controller;

import com.example.geothermal.entity.PurchaseOrder;
import com.example.geothermal.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
@CrossOrigin(origins = "*")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(
            PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }

    @GetMapping("/{id}")
    public PurchaseOrder getPurchaseOrderById(@PathVariable Integer id) {
        return purchaseOrderService
                .getPurchaseOrderById(id)
                .orElse(null);
    }

    @PostMapping
    public PurchaseOrder createPurchaseOrder(
            @RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.savePurchaseOrder(purchaseOrder);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseOrder(@PathVariable Integer id) {
        purchaseOrderService.deletePurchaseOrder(id);
    }
}