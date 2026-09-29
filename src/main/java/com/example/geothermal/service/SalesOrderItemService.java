package com.example.geothermal.service;

import com.example.geothermal.entity.SalesOrderItem;
import com.example.geothermal.repository.SalesOrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderItemService {

    private final SalesOrderItemRepository salesOrderItemRepository;

    public SalesOrderItemService(
            SalesOrderItemRepository salesOrderItemRepository) {
        this.salesOrderItemRepository = salesOrderItemRepository;
    }

    public List<SalesOrderItem> getAllItems() {
        return salesOrderItemRepository.findAll();
    }

    public Optional<SalesOrderItem> getItemById(Integer id) {
        return salesOrderItemRepository.findById(id);
    }

    public SalesOrderItem saveItem(SalesOrderItem item) {
        return salesOrderItemRepository.save(item);
    }

    public void deleteItem(Integer id) {
        salesOrderItemRepository.deleteById(id);
    }
}