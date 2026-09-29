package com.example.geothermal.controller;

import com.example.geothermal.entity.Vendor;
import com.example.geothermal.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Integer id) {
        return vendorService.getVendorById(id).orElse(null);
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Integer id) {
        vendorService.deleteVendor(id);
    }
}