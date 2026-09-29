package com.example.geothermal.repository;

import com.example.geothermal.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}