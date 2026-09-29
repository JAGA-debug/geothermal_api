package com.example.geothermal.repository;

import com.example.geothermal.entity.GeothermalLoop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeothermalLoopRepository extends JpaRepository<GeothermalLoop, Integer> {
}