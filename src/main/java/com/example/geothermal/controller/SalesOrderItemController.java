package com.example.geothermal.controller;

import com.example.geothermal.entity.SalesOrderItem;
import com.example.geothermal.service.SalesOrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-order-items")
@CrossOrigin(origins = "*")
public class SalesOrderItemController {

    private final SalesOrderItemService salesOrderItemService;

    public SalesOrderItemController(
            SalesOrderItemService salesOrderItemService) {
        this.salesOrderItemService = salesOrderItemService;
    }

    @GetMapping
    public List<SalesOrderItem> getAllItems() {
        return salesOrderItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public SalesOrderItem getItemById(@PathVariable Integer id) {
        return salesOrderItemService
                .getItemById(id)
                .orElse(null);
    }

    @PostMapping
    public SalesOrderItem createItem(
            @RequestBody SalesOrderItem item) {
        return salesOrderItemService.saveItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id) {
        salesOrderItemService.deleteItem(id);
    }
}