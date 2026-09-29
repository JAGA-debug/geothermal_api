package com.example.geothermal.service;

import com.example.geothermal.entity.*;
import com.example.geothermal.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionService {

    private final JournalEntryRepository journalEntryRepository;
    private final JournalEntryLineRepository journalEntryLineRepository;
    private final JournalRepository journalRepository;
    private final AccountRepository accountRepository;

    public TransactionService(
            JournalEntryRepository journalEntryRepository,
            JournalEntryLineRepository journalEntryLineRepository,
            JournalRepository journalRepository,
            AccountRepository accountRepository) {

        this.journalEntryRepository = journalEntryRepository;
        this.journalEntryLineRepository = journalEntryLineRepository;
        this.journalRepository = journalRepository;
        this.accountRepository = accountRepository;
    }

    public void recordCustomerPayment(Payment payment) {

        Journal journal = journalRepository
                .findAll()
                .stream()
                .filter(j -> "Cash".equalsIgnoreCase(j.getJournalName())
                        || "Bank".equalsIgnoreCase(j.getJournalName()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Cash/Bank journal not found"));

        Account cashAccount = accountRepository
                .findAll()
                .stream()
                .filter(a -> "Cash/Bank".equalsIgnoreCase(a.getAccountName()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Cash/Bank account not found"));

        Account revenueAccount = accountRepository
                .findAll()
                .stream()
                .filter(a -> "Geothermal Heating & Cooling Revenue"
                        .equalsIgnoreCase(a.getAccountName()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Revenue account not found"));

        JournalEntry entry = new JournalEntry();

        entry.setJournal(journal);
        entry.setEntryDate(
                payment.getPaymentDate() != null
                        ? payment.getPaymentDate()
                        : LocalDate.now());

        entry.setReferenceType("CUSTOMER_PAYMENT");
        entry.setReferenceId(payment.getId());
        entry.setDescription("Customer payment received");

        JournalEntry savedEntry =
                journalEntryRepository.save(entry);

        JournalEntryLine debitLine = new JournalEntryLine();

        debitLine.setJournalEntry(savedEntry);
        debitLine.setAccount(cashAccount);
        debitLine.setDebitAmount(payment.getAmount());
        debitLine.setCreditAmount(0.0);
        debitLine.setDescription("Cash/Bank received");

        journalEntryLineRepository.save(debitLine);

        JournalEntryLine creditLine = new JournalEntryLine();

        creditLine.setJournalEntry(savedEntry);
        creditLine.setAccount(revenueAccount);
        creditLine.setDebitAmount(0.0);
        creditLine.setCreditAmount(payment.getAmount());
        creditLine.setDescription("Geothermal revenue");

        journalEntryLineRepository.save(creditLine);
    }

    public void recordVendorPayment(VendorPayment payment) {

        Journal journal = journalRepository
                .findAll()
                .stream()
                .filter(j -> "Cash".equalsIgnoreCase(j.getJournalName())
                        || "Bank".equalsIgnoreCase(j.getJournalName()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Cash/Bank journal not found"));

        Account cashAccount = accountRepository
                .findAll()
                .stream()
                .filter(a -> "Cash/Bank".equalsIgnoreCase(a.getAccountName()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Cash/Bank account not found"));

        Account creditorAccount = accountRepository
                .findAll()
                .stream()
                .filter(a -> "Equipment Vendor Creditors"
                        .equalsIgnoreCase(a.getAccountName()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Vendor creditor account not found"));

        JournalEntry entry = new JournalEntry();

        entry.setJournal(journal);

        entry.setEntryDate(
                payment.getPaymentDate() != null
                        ? payment.getPaymentDate()
                        : LocalDate.now());

        entry.setReferenceType("VENDOR_PAYMENT");
        entry.setReferenceId(payment.getId());
        entry.setDescription("Vendor payment made");

        JournalEntry savedEntry =
                journalEntryRepository.save(entry);

        JournalEntryLine debitLine = new JournalEntryLine();

        debitLine.setJournalEntry(savedEntry);
        debitLine.setAccount(creditorAccount);
        debitLine.setDebitAmount(payment.getAmount());
        debitLine.setCreditAmount(0.0);
        debitLine.setDescription("Vendor creditor payment");

        journalEntryLineRepository.save(debitLine);

        JournalEntryLine creditLine = new JournalEntryLine();

        creditLine.setJournalEntry(savedEntry);
        creditLine.setAccount(cashAccount);
        creditLine.setDebitAmount(0.0);
        creditLine.setCreditAmount(payment.getAmount());
        creditLine.setDescription("Cash/Bank payment");

        journalEntryLineRepository.save(creditLine);
    }
}