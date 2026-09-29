package com.example.geothermal.service;

import com.example.geothermal.entity.GeothermalLoop;
import com.example.geothermal.repository.GeothermalLoopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeothermalLoopService {

    private final GeothermalLoopRepository geothermalLoopRepository;

    public GeothermalLoopService(GeothermalLoopRepository geothermalLoopRepository) {
        this.geothermalLoopRepository = geothermalLoopRepository;
    }

    public List<GeothermalLoop> getAllLoops() {
        return geothermalLoopRepository.findAll();
    }

    public Optional<GeothermalLoop> getLoopById(Integer id) {
        return geothermalLoopRepository.findById(id);
    }

    public GeothermalLoop saveLoop(GeothermalLoop loop) {
        return geothermalLoopRepository.save(loop);
    }

    public void deleteLoop(Integer id) {
        geothermalLoopRepository.deleteById(id);
    }
}