package com.example.geothermal.service;

import com.example.geothermal.entity.Journal;
import com.example.geothermal.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(Integer id) {
        return journalRepository.findById(id);
    }

    public Journal saveJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public void deleteJournal(Integer id) {
        journalRepository.deleteById(id);
    }
}