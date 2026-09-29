package com.example.geothermal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "boreholes")
public class Borehole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "borehole_name", nullable = false)
    private String boreholeName;

    private String location;

    @Column(name = "depth_meters")
    private Double depthMeters;

    private String status;

    public Borehole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoreholeName() {
        return boreholeName;
    }

    public void setBoreholeName(String boreholeName) {
        this.boreholeName = boreholeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getDepthMeters() {
        return depthMeters;
    }

    public void setDepthMeters(Double depthMeters) {
        this.depthMeters = depthMeters;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}