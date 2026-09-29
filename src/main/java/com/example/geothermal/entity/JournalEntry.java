package com.example.geothermal.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "journal_entries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "journal_id", nullable = false)
    private Journal journal;

    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;

    @Column(name = "reference_type")
    private String referenceType;

    @Column(name = "reference_id")
    private Integer referenceId;

    private String description;

    public JournalEntry() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}