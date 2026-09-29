package com.example.geothermal.controller;

import com.example.geothermal.entity.Journal;
import com.example.geothermal.service.JournalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journals")
@CrossOrigin(origins = "*")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping
    public List<Journal> getAllJournals() {
        return journalService.getAllJournals();
    }

    @GetMapping("/{id}")
    public Journal getJournalById(@PathVariable Integer id) {
        return journalService.getJournalById(id).orElse(null);
    }

    @PostMapping
    public Journal createJournal(@RequestBody Journal journal) {
        return journalService.saveJournal(journal);
    }

    @DeleteMapping("/{id}")
    public void deleteJournal(@PathVariable Integer id) {
        journalService.deleteJournal(id);
    }
}