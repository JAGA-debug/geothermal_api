package com.example.geothermal.service;

import com.example.geothermal.entity.Telemetry;
import com.example.geothermal.repository.TelemetryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelemetryService {

    private final TelemetryRepository telemetryRepository;

    public TelemetryService(TelemetryRepository telemetryRepository) {
        this.telemetryRepository = telemetryRepository;
    }

    public List<Telemetry> getAllTelemetry() {
        return telemetryRepository.findAll();
    }

    public Optional<Telemetry> getTelemetryById(Integer id) {
        return telemetryRepository.findById(id);
    }

    public Telemetry saveTelemetry(Telemetry telemetry) {
        return telemetryRepository.save(telemetry);
    }

    public void deleteTelemetry(Integer id) {
        telemetryRepository.deleteById(id);
    }
}