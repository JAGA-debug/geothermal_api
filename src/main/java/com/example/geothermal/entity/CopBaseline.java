package com.example.geothermal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cop_baselines")
public class CopBaseline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "loop_id", nullable = false)
    private GeothermalLoop loop;

    @Column(nullable = false)
    private String season;

    @Column(name = "cop_value", nullable = false)
    private Double copValue;

    @Column(nullable = false)
    private Integer year;

    public CopBaseline() {
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Double getCopValue() {
        return copValue;
    }

    public void setCopValue(Double copValue) {
        this.copValue = copValue;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}