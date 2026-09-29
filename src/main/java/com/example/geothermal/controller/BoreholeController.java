package com.example.geothermal.controller;

import com.example.geothermal.entity.Borehole;
import com.example.geothermal.service.BoreholeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boreholes")
@CrossOrigin(origins = "*")
public class BoreholeController {

    private final BoreholeService boreholeService;

    public BoreholeController(BoreholeService boreholeService) {
        this.boreholeService = boreholeService;
    }

    @GetMapping
    public List<Borehole> getAllBoreholes() {
        return boreholeService.getAllBoreholes();
    }

    @GetMapping("/{id}")
    public Borehole getBoreholeById(@PathVariable Integer id) {
        return boreholeService.getBoreholeById(id).orElse(null);
    }

    @PostMapping
    public Borehole createBorehole(@RequestBody Borehole borehole) {
        return boreholeService.saveBorehole(borehole);
    }

    @DeleteMapping("/{id}")
    public void deleteBorehole(@PathVariable Integer id) {
        boreholeService.deleteBorehole(id);
    }
}