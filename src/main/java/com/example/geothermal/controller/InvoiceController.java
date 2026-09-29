package com.example.geothermal.controller;

import com.example.geothermal.entity.Invoice;
import com.example.geothermal.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id) {
        return invoiceService.getInvoiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(
            @PathVariable Integer id,
            @RequestBody Invoice invoice) {

        return invoiceService.getInvoiceById(id)
                .map(existingInvoice -> {
                    invoice.setId(id);
                    return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Integer id) {

        if (invoiceService.getInvoiceById(id).isPresent()) {
            invoiceService.deleteInvoice(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}