package com.example.geothermal.controller;

import com.example.geothermal.entity.VendorPayment;
import com.example.geothermal.service.VendorPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-payments")
@CrossOrigin(origins = "*")
public class VendorPaymentController {

    private final VendorPaymentService vendorPaymentService;

    public VendorPaymentController(
            VendorPaymentService vendorPaymentService) {
        this.vendorPaymentService = vendorPaymentService;
    }

    @GetMapping
    public List<VendorPayment> getAllVendorPayments() {
        return vendorPaymentService.getAllVendorPayments();
    }

    @GetMapping("/{id}")
    public VendorPayment getVendorPaymentById(
            @PathVariable Integer id) {

        return vendorPaymentService
                .getVendorPaymentById(id)
                .orElse(null);
    }

    @PostMapping
    public VendorPayment createVendorPayment(
            @RequestBody VendorPayment vendorPayment) {

        return vendorPaymentService.saveVendorPayment(vendorPayment);
    }

    @DeleteMapping("/{id}")
    public void deleteVendorPayment(@PathVariable Integer id) {
        vendorPaymentService.deleteVendorPayment(id);
    }
}