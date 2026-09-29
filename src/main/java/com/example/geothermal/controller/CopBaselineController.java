package com.example.geothermal.controller;

import com.example.geothermal.entity.CopBaseline;
import com.example.geothermal.service.CopBaselineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geothermal/cop-baselines")
@CrossOrigin(origins = "*")
public class CopBaselineController {

    private final CopBaselineService copBaselineService;

    public CopBaselineController(CopBaselineService copBaselineService) {
        this.copBaselineService = copBaselineService;
    }

    @GetMapping
    public List<CopBaseline> getAllCopBaselines() {
        return copBaselineService.getAllCopBaselines();
    }

    @GetMapping("/{id}")
    public CopBaseline getCopBaselineById(@PathVariable Integer id) {
        return copBaselineService.getCopBaselineById(id).orElse(null);
    }

    @PostMapping
    public CopBaseline createCopBaseline(@RequestBody CopBaseline copBaseline) {
        return copBaselineService.saveCopBaseline(copBaseline);
    }

    @DeleteMapping("/{id}")
    public void deleteCopBaseline(@PathVariable Integer id) {
        copBaselineService.deleteCopBaseline(id);
    }
}