package com.example.geothermal.controller;

import com.example.geothermal.entity.GeothermalLoop;
import com.example.geothermal.service.GeothermalLoopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geothermal/loops")
@CrossOrigin(origins = "*")
public class GeothermalLoopController {

    private final GeothermalLoopService geothermalLoopService;

    public GeothermalLoopController(GeothermalLoopService geothermalLoopService) {
        this.geothermalLoopService = geothermalLoopService;
    }

    @GetMapping
    public List<GeothermalLoop> getAllLoops() {
        return geothermalLoopService.getAllLoops();
    }

    @GetMapping("/{id}")
    public GeothermalLoop getLoopById(@PathVariable Integer id) {
        return geothermalLoopService.getLoopById(id).orElse(null);
    }

    @PostMapping
    public GeothermalLoop createLoop(@RequestBody GeothermalLoop loop) {
        return geothermalLoopService.saveLoop(loop);
    }

    @DeleteMapping("/{id}")
    public void deleteLoop(@PathVariable Integer id) {
        geothermalLoopService.deleteLoop(id);
    }
}