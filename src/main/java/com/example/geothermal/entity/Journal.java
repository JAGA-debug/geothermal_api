package com.example.geothermal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "journals")
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "journal_name", nullable = false)
    private String journalName;

    @Column(name = "journal_type", nullable = false)
    private String journalType;

    private String description;

    private String status;

    public Journal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getJournalType() {
        return journalType;
    }

    public void setJournalType(String journalType) {
        this.journalType = journalType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}