package com.example.geothermal.controller;

import com.example.geothermal.entity.VendorBill;
import com.example.geothermal.service.VendorBillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-bills")
@CrossOrigin(origins = "*")
public class VendorBillController {

    private final VendorBillService vendorBillService;

    public VendorBillController(VendorBillService vendorBillService) {
        this.vendorBillService = vendorBillService;
    }

    @GetMapping
    public List<VendorBill> getAllVendorBills() {
        return vendorBillService.getAllVendorBills();
    }

    @GetMapping("/{id}")
    public VendorBill getVendorBillById(@PathVariable Integer id) {
        return vendorBillService
                .getVendorBillById(id)
                .orElse(null);
    }

    @PostMapping
    public VendorBill createVendorBill(
            @RequestBody VendorBill vendorBill) {
        return vendorBillService.saveVendorBill(vendorBill);
    }

    @DeleteMapping("/{id}")
    public void deleteVendorBill(@PathVariable Integer id) {
        vendorBillService.deleteVendorBill(id);
    }
}