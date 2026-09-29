package com.example.geothermal.controller;

import com.example.geothermal.entity.JournalEntry;
import com.example.geothermal.service.JournalEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal-entries")
@CrossOrigin(origins = "*")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping
    public List<JournalEntry> getAllEntries() {
        return journalEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable Integer id) {
        return journalEntryService.getEntryById(id).orElse(null);
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        return journalEntryService.saveEntry(entry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Integer id) {
        journalEntryService.deleteEntry(id);
    }
}