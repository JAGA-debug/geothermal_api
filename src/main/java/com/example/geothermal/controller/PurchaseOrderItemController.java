package com.example.geothermal.controller;

import com.example.geothermal.entity.PurchaseOrderItem;
import com.example.geothermal.service.PurchaseOrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-order-items")
@CrossOrigin(origins = "*")
public class PurchaseOrderItemController {

    private final PurchaseOrderItemService purchaseOrderItemService;

    public PurchaseOrderItemController(
            PurchaseOrderItemService purchaseOrderItemService) {
        this.purchaseOrderItemService = purchaseOrderItemService;
    }

    @GetMapping
    public List<PurchaseOrderItem> getAllItems() {
        return purchaseOrderItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public PurchaseOrderItem getItemById(@PathVariable Integer id) {
        return purchaseOrderItemService
                .getItemById(id)
                .orElse(null);
    }

    @PostMapping
    public PurchaseOrderItem createItem(
            @RequestBody PurchaseOrderItem item) {
        return purchaseOrderItemService.saveItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id) {
        purchaseOrderItemService.deleteItem(id);
    }
}