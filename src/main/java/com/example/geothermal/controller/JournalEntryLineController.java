package com.example.geothermal.controller;

import com.example.geothermal.entity.JournalEntryLine;
import com.example.geothermal.service.JournalEntryLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal-entry-lines")
@CrossOrigin(origins = "*")
public class JournalEntryLineController {

    private final JournalEntryLineService journalEntryLineService;

    public JournalEntryLineController(
            JournalEntryLineService journalEntryLineService) {
        this.journalEntryLineService = journalEntryLineService;
    }

    @GetMapping
    public List<JournalEntryLine> getAllLines() {
        return journalEntryLineService.getAllLines();
    }

    @GetMapping("/{id}")
    public JournalEntryLine getLineById(@PathVariable Integer id) {
        return journalEntryLineService.getLineById(id).orElse(null);
    }

    @PostMapping
    public JournalEntryLine createLine(
            @RequestBody JournalEntryLine line) {
        return journalEntryLineService.saveLine(line);
    }

    @DeleteMapping("/{id}")
    public void deleteLine(@PathVariable Integer id) {
        journalEntryLineService.deleteLine(id);
    }
}