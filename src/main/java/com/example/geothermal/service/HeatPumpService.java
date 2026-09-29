package com.example.geothermal.service;

import com.example.geothermal.entity.HeatPump;
import com.example.geothermal.repository.HeatPumpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeatPumpService {

    private final HeatPumpRepository heatPumpRepository;

    public HeatPumpService(HeatPumpRepository heatPumpRepository) {
        this.heatPumpRepository = heatPumpRepository;
    }

    public List<HeatPump> getAllHeatPumps() {
        return heatPumpRepository.findAll();
    }

    public Optional<HeatPump> getHeatPumpById(Integer id) {
        return heatPumpRepository.findById(id);
    }

    public HeatPump saveHeatPump(HeatPump heatPump) {
        return heatPumpRepository.save(heatPump);
    }

    public void deleteHeatPump(Integer id) {
        heatPumpRepository.deleteById(id);
    }
}