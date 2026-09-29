package com.example.geothermal.repository;

import com.example.geothermal.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Integer> {
}