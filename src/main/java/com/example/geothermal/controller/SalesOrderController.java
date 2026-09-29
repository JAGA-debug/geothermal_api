package com.example.geothermal.controller;

import com.example.geothermal.entity.SalesOrder;
import com.example.geothermal.service.SalesOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-orders")
@CrossOrigin(origins = "*")
public class SalesOrderController {

    private final SalesOrderService salesOrderService;

    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @GetMapping
    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderService.getAllSalesOrders();
    }

    @GetMapping("/{id}")
    public SalesOrder getSalesOrderById(@PathVariable Integer id) {
        return salesOrderService
                .getSalesOrderById(id)
                .orElse(null);
    }

    @PostMapping
    public SalesOrder createSalesOrder(
            @RequestBody SalesOrder salesOrder) {
        return salesOrderService.saveSalesOrder(salesOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteSalesOrder(@PathVariable Integer id) {
        salesOrderService.deleteSalesOrder(id);
    }
}