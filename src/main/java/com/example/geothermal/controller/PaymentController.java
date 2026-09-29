package com.example.geothermal.controller;

import com.example.geothermal.entity.Payment;
import com.example.geothermal.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(
            @PathVariable Integer id,
            @RequestBody Payment payment) {

        return paymentService.getPaymentById(id)
                .map(existingPayment -> {
                    payment.setId(id);
                    return ResponseEntity.ok(paymentService.savePayment(payment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id) {

        if (paymentService.getPaymentById(id).isPresent()) {
            paymentService.deletePayment(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}