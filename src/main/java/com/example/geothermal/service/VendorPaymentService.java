package com.example.geothermal.service;

import com.example.geothermal.entity.VendorPayment;
import com.example.geothermal.repository.VendorPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorPaymentService {

    private final VendorPaymentRepository vendorPaymentRepository;
    private final TransactionService transactionService;

    public VendorPaymentService(
            VendorPaymentRepository vendorPaymentRepository,
            TransactionService transactionService) {

        this.vendorPaymentRepository = vendorPaymentRepository;
        this.transactionService = transactionService;
    }

    public List<VendorPayment> getAllVendorPayments() {
        return vendorPaymentRepository.findAll();
    }

    public Optional<VendorPayment> getVendorPaymentById(Integer id) {
        return vendorPaymentRepository.findById(id);
    }

    public VendorPayment saveVendorPayment(
            VendorPayment vendorPayment) {

        VendorPayment savedPayment =
                vendorPaymentRepository.save(vendorPayment);

        if ("Paid".equalsIgnoreCase(savedPayment.getStatus())) {
            transactionService.recordVendorPayment(savedPayment);
        }

        return savedPayment;
    }

    public void deleteVendorPayment(Integer id) {
        vendorPaymentRepository.deleteById(id);
    }
}