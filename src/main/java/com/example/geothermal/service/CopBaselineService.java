package com.example.geothermal.service;

import com.example.geothermal.entity.CopBaseline;
import com.example.geothermal.repository.CopBaselineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CopBaselineService {

    private final CopBaselineRepository copBaselineRepository;

    public CopBaselineService(CopBaselineRepository copBaselineRepository) {
        this.copBaselineRepository = copBaselineRepository;
    }

    public List<CopBaseline> getAllCopBaselines() {
        return copBaselineRepository.findAll();
    }

    public Optional<CopBaseline> getCopBaselineById(Integer id) {
        return copBaselineRepository.findById(id);
    }

    public CopBaseline saveCopBaseline(CopBaseline copBaseline) {
        return copBaselineRepository.save(copBaseline);
    }

    public void deleteCopBaseline(Integer id) {
        copBaselineRepository.deleteById(id);
    }
}