package com.example.geothermal.repository;

import com.example.geothermal.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Integer> {
}