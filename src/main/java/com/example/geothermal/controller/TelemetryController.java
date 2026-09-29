package com.example.geothermal.controller;

import com.example.geothermal.entity.Telemetry;
import com.example.geothermal.service.TelemetryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geothermal/telemetry")
@CrossOrigin(origins = "*")
public class TelemetryController {

    private final TelemetryService telemetryService;

    public TelemetryController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @GetMapping
    public List<Telemetry> getAllTelemetry() {
        return telemetryService.getAllTelemetry();
    }

    @GetMapping("/{id}")
    public Telemetry getTelemetryById(@PathVariable Integer id) {
        return telemetryService.getTelemetryById(id).orElse(null);
    }

    @PostMapping
    public Telemetry createTelemetry(@RequestBody Telemetry telemetry) {
        return telemetryService.saveTelemetry(telemetry);
    }

    @DeleteMapping("/{id}")
    public void deleteTelemetry(@PathVariable Integer id) {
        telemetryService.deleteTelemetry(id);
    }
}