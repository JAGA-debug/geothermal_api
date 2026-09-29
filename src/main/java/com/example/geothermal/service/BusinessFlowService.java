package com.example.geothermal.service;

import com.example.geothermal.entity.*;
import com.example.geothermal.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BusinessFlowService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final VendorBillRepository vendorBillRepository;
    private final VendorPaymentRepository vendorPaymentRepository;

    private final SalesOrderRepository salesOrderRepository;
    private final InvoiceRepository invoiceRepository;
    private final PaymentRepository paymentRepository;

    private final TransactionService transactionService;

    public BusinessFlowService(
            PurchaseOrderRepository purchaseOrderRepository,
            VendorBillRepository vendorBillRepository,
            VendorPaymentRepository vendorPaymentRepository,
            SalesOrderRepository salesOrderRepository,
            InvoiceRepository invoiceRepository,
            PaymentRepository paymentRepository,
            TransactionService transactionService) {

        this.purchaseOrderRepository = purchaseOrderRepository;
        this.vendorBillRepository = vendorBillRepository;
        this.vendorPaymentRepository = vendorPaymentRepository;

        this.salesOrderRepository = salesOrderRepository;
        this.invoiceRepository = invoiceRepository;
        this.paymentRepository = paymentRepository;

        this.transactionService = transactionService;
    }

    // PURCHASE FLOW
    public VendorBill createVendorBillFromPurchaseOrder(
            Integer purchaseOrderId,
            String billNumber,
            LocalDate billDate,
            LocalDate dueDate) {

        PurchaseOrder purchaseOrder =
                purchaseOrderRepository.findById(purchaseOrderId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Purchase Order not found"));

        VendorBill bill = new VendorBill();

        bill.setBillNumber(billNumber);
        bill.setVendor(purchaseOrder.getVendor());
        bill.setPurchaseOrder(purchaseOrder);
        bill.setBillDate(
                billDate != null ? billDate : LocalDate.now());
        bill.setDueDate(dueDate);
        bill.setAmount(purchaseOrder.getTotalAmount());
        bill.setStatus("Unpaid");
        bill.setNotes("Created from Purchase Order "
                + purchaseOrder.getPoNumber());

        return vendorBillRepository.save(bill);
    }

    // SALES FLOW
    public Invoice createInvoiceFromSalesOrder(
            Integer salesOrderId,
            String invoiceNumber,
            Telemetry telemetry) {

        SalesOrder salesOrder =
                salesOrderRepository.findById(salesOrderId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Sales Order not found"));

        Invoice invoice = new Invoice();

        invoice.setInvoiceNumber(invoiceNumber);
        invoice.setCustomer(salesOrder.getCustomer());
        invoice.setSalesOrder(salesOrder);
        invoice.setTelemetry(telemetry);
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setAmount(salesOrder.getTotalAmount());
        invoice.setStatus("Unpaid");
        invoice.setNotes("Created from Sales Order "
                + salesOrder.getOrderNumber());

        if (telemetry != null) {
            invoice.setEnergyGj(telemetry.getEnergyGj());
        }

        return invoiceRepository.save(invoice);
    }
}