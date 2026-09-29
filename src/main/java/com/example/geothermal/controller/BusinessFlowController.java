package com.example.geothermal.controller;

import com.example.geothermal.entity.Invoice;
import com.example.geothermal.entity.Telemetry;
import com.example.geothermal.entity.VendorBill;
import com.example.geothermal.service.BusinessFlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/business-flow")
@CrossOrigin(origins = "*")
public class BusinessFlowController {

    private final BusinessFlowService businessFlowService;

    public BusinessFlowController(
            BusinessFlowService businessFlowService) {
        this.businessFlowService = businessFlowService;
    }

    @PostMapping("/purchase-order/{purchaseOrderId}/vendor-bill")
    public ResponseEntity<VendorBill> createVendorBill(
            @PathVariable Integer purchaseOrderId,
            @RequestParam String billNumber,
            @RequestParam(required = false) String billDate,
            @RequestParam(required = false) String dueDate) {

        LocalDate billDateValue =
                billDate != null
                        ? LocalDate.parse(billDate)
                        : LocalDate.now();

        LocalDate dueDateValue =
                dueDate != null
                        ? LocalDate.parse(dueDate)
                        : LocalDate.now().plusDays(30);

        VendorBill bill =
                businessFlowService
                        .createVendorBillFromPurchaseOrder(
                                purchaseOrderId,
                                billNumber,
                                billDateValue,
                                dueDateValue);

        return ResponseEntity.ok(bill);
    }

    @PostMapping("/sales-order/{salesOrderId}/invoice")
    public ResponseEntity<Invoice> createInvoice(
            @PathVariable Integer salesOrderId,
            @RequestParam String invoiceNumber,
            @RequestBody(required = false) Telemetry telemetry) {

        Invoice invoice =
                businessFlowService.createInvoiceFromSalesOrder(
                        salesOrderId,
                        invoiceNumber,
                        telemetry);

        return ResponseEntity.ok(invoice);
    }
}