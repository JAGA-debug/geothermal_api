package com.example.geothermal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "journal_entry_lines")
public class JournalEntryLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "journal_entry_id", nullable = false)
    private JournalEntry journalEntry;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "debit_amount")
    private Double debitAmount;

    @Column(name = "credit_amount")
    private Double creditAmount;

    private String description;

    public JournalEntryLine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(JournalEntry journalEntry) {
        this.journalEntry = journalEntry;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}