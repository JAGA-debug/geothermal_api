package com.example.geothermal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "geothermal_loops")
public class GeothermalLoop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loop_name", nullable = false)
    private String loopName;

    @Column(name = "zone_name")
    private String zoneName;

    @ManyToOne
    @JoinColumn(name = "borehole_id", nullable = false)
    private Borehole borehole;

    @ManyToOne
    @JoinColumn(name = "heatpump_id", nullable = false)
    private HeatPump heatPump;

    @Column(name = "flow_rate")
    private Double flowRate;

    private String status;

    private String description;

    public GeothermalLoop() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Borehole getBorehole() {
        return borehole;
    }

    public void setBorehole(Borehole borehole) {
        this.borehole = borehole;
    }

    public HeatPump getHeatPump() {
        return heatPump;
    }

    public void setHeatPump(HeatPump heatPump) {
        this.heatPump = heatPump;
    }

    public Double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(Double flowRate) {
        this.flowRate = flowRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}