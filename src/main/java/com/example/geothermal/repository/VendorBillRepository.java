package com.example.geothermal.repository;

import com.example.geothermal.entity.VendorBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorBillRepository
        extends JpaRepository<VendorBill, Integer> {
}
