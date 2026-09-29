package com.example.geothermal.repository;

import com.example.geothermal.entity.VendorPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorPaymentRepository
        extends JpaRepository<VendorPayment, Integer> {
}