package com.example.geothermal.service;

import com.example.geothermal.entity.SalesOrder;
import com.example.geothermal.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {

    private final SalesOrderRepository salesOrderRepository;

    public SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderRepository.findAll();
    }

    public Optional<SalesOrder> getSalesOrderById(Integer id) {
        return salesOrderRepository.findById(id);
    }

    public SalesOrder saveSalesOrder(SalesOrder salesOrder) {
        return salesOrderRepository.save(salesOrder);
    }

    public void deleteSalesOrder(Integer id) {
        salesOrderRepository.deleteById(id);
    }
}