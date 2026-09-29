package com.example.geothermal.repository;

import com.example.geothermal.entity.Borehole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoreholeRepository extends JpaRepository<Borehole, Integer> {
}