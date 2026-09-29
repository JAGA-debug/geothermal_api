package com.example.geothermal.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry")
public class Telemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "loop_id", nullable = false)
    private GeothermalLoop loop;

    @Column(name = "reading_date", nullable = false)
    private LocalDateTime readingDate;

    @Column(name = "flow_rate")
    private Double flowRate;

    @Column(name = "supply_temperature")
    private Double supplyTemperature;

    @Column(name = "return_temperature")
    private Double returnTemperature;

    @Column(name = "energy_gj")
    private Double energyGj;

    private String notes;

    public Telemetry() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeothermalLoop getLoop() {
        return loop;
    }

    public void setLoop(GeothermalLoop loop) {
        this.loop = loop;
    }

    public LocalDateTime getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(LocalDateTime readingDate) {
        this.readingDate = readingDate;
    }

    public Double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(Double flowRate) {
        this.flowRate = flowRate;
    }

    public Double getSupplyTemperature() {
        return supplyTemperature;
    }

    public void setSupplyTemperature(Double supplyTemperature) {
        this.supplyTemperature = supplyTemperature;
    }

    public Double getReturnTemperature() {
        return returnTemperature;
    }

    public void setReturnTemperature(Double returnTemperature) {
        this.returnTemperature = returnTemperature;
    }

    public Double getEnergyGj() {
        return energyGj;
    }

    public void setEnergyGj(Double energyGj) {
        this.energyGj = energyGj;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}