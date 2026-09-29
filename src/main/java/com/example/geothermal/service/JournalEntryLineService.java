package com.example.geothermal.service;

import com.example.geothermal.entity.JournalEntryLine;
import com.example.geothermal.repository.JournalEntryLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryLineService {

    private final JournalEntryLineRepository journalEntryLineRepository;

    public JournalEntryLineService(
            JournalEntryLineRepository journalEntryLineRepository) {
        this.journalEntryLineRepository = journalEntryLineRepository;
    }

    public List<JournalEntryLine> getAllLines() {
        return journalEntryLineRepository.findAll();
    }

    public Optional<JournalEntryLine> getLineById(Integer id) {
        return journalEntryLineRepository.findById(id);
    }

    public JournalEntryLine saveLine(JournalEntryLine line) {
        return journalEntryLineRepository.save(line);
    }

    public void deleteLine(Integer id) {
        journalEntryLineRepository.deleteById(id);
    }
}