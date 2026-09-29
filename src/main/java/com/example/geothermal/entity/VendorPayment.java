package com.example.geothermal.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vendor_payments")
public class VendorPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vendor_bill_id", nullable = false)
    private VendorBill vendorBill;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    private Double amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String status;

    private String reference;

    public VendorPayment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VendorBill getVendorBill() {
        return vendorBill;
    }

    public void setVendorBill(VendorBill vendorBill) {
        this.vendorBill = vendorBill;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}