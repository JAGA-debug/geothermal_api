package com.example.geothermal.service;

import com.example.geothermal.entity.VendorBill;
import com.example.geothermal.repository.VendorBillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorBillService {

    private final VendorBillRepository vendorBillRepository;

    public VendorBillService(VendorBillRepository vendorBillRepository) {
        this.vendorBillRepository = vendorBillRepository;
    }

    public List<VendorBill> getAllVendorBills() {
        return vendorBillRepository.findAll();
    }

    public Optional<VendorBill> getVendorBillById(Integer id) {
        return vendorBillRepository.findById(id);
    }

    public VendorBill saveVendorBill(VendorBill vendorBill) {
        return vendorBillRepository.save(vendorBill);
    }

    public void deleteVendorBill(Integer id) {
        vendorBillRepository.deleteById(id);
    }
}