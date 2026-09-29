package com.example.geothermal.service;

import com.example.geothermal.entity.JournalEntry;
import com.example.geothermal.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(Integer id) {
        return journalEntryRepository.findById(id);
    }

    public JournalEntry saveEntry(JournalEntry entry) {
        return journalEntryRepository.save(entry);
    }

    public void deleteEntry(Integer id) {
        journalEntryRepository.deleteById(id);
    }
}