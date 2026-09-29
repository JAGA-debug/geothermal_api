package com.example.geothermal.service;

import com.example.geothermal.entity.Borehole;
import com.example.geothermal.repository.BoreholeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoreholeService {

    private final BoreholeRepository boreholeRepository;

    public BoreholeService(BoreholeRepository boreholeRepository) {
        this.boreholeRepository = boreholeRepository;
    }

    public List<Borehole> getAllBoreholes() {
        return boreholeRepository.findAll();
    }

    public Optional<Borehole> getBoreholeById(Integer id) {
        return boreholeRepository.findById(id);
    }

    public Borehole saveBorehole(Borehole borehole) {
        return boreholeRepository.save(borehole);
    }

    public void deleteBorehole(Integer id) {
        boreholeRepository.deleteById(id);
    }
}