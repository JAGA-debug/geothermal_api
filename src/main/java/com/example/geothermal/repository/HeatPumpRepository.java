package com.example.geothermal.repository;

import com.example.geothermal.entity.HeatPump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeatPumpRepository extends JpaRepository<HeatPump, Integer> {
}