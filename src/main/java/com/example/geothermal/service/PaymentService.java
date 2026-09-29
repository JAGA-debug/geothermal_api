package com.example.geothermal.service;

import com.example.geothermal.entity.Payment;
import com.example.geothermal.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final TransactionService transactionService;

    public PaymentService(
            PaymentRepository paymentRepository,
            TransactionService transactionService) {

        this.paymentRepository = paymentRepository;
        this.transactionService = transactionService;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    public Payment savePayment(Payment payment) {

        Payment savedPayment = paymentRepository.save(payment);

        if ("Paid".equalsIgnoreCase(savedPayment.getStatus())) {
            transactionService.recordCustomerPayment(savedPayment);
        }

        return savedPayment;
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }
}