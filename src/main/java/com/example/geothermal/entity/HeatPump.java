package com.example.geothermal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "heatpumps")
public class HeatPump {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pump_name", nullable = false)
    private String pumpName;

    @Column(name = "capacity_kw")
    private Double capacityKw;

    private String status;

    public HeatPump() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPumpName() {
        return pumpName;
    }

    public void setPumpName(String pumpName) {
        this.pumpName = pumpName;
    }

    public Double getCapacityKw() {
        return capacityKw;
    }

    public void setCapacityKw(Double capacityKw) {
        this.capacityKw = capacityKw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}