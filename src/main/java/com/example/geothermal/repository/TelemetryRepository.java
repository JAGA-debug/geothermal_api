package com.example.geothermal.repository;

import com.example.geothermal.entity.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetryRepository extends JpaRepository<Telemetry, Integer> {
}