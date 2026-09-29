package com.example.geothermal.repository;

import com.example.geothermal.entity.JournalEntryLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryLineRepository extends JpaRepository<JournalEntryLine, Integer> {
}