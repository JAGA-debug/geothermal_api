package com.example.geothermal.controller;

import com.example.geothermal.entity.HeatPump;
import com.example.geothermal.service.HeatPumpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heatpumps")
@CrossOrigin(origins = "*")
public class HeatPumpController {

    private final HeatPumpService heatPumpService;

    public HeatPumpController(HeatPumpService heatPumpService) {
        this.heatPumpService = heatPumpService;
    }

    @GetMapping
    public List<HeatPump> getAllHeatPumps() {
        return heatPumpService.getAllHeatPumps();
    }

    @GetMapping("/{id}")
    public HeatPump getHeatPumpById(@PathVariable Integer id) {
        return heatPumpService.getHeatPumpById(id).orElse(null);
    }

    @PostMapping
    public HeatPump createHeatPump(@RequestBody HeatPump heatPump) {
        return heatPumpService.saveHeatPump(heatPump);
    }

    @DeleteMapping("/{id}")
    public void deleteHeatPump(@PathVariable Integer id) {
        heatPumpService.deleteHeatPump(id);
    }
}