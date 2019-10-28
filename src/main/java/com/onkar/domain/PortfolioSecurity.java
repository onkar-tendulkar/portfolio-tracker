package com.onkar.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class PortfolioSecurity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String symbol;
    private Integer units;
    private Float costPerUnit;
    private Date datePurchased;

    @Column(name = "created_time", insertable=false)
    private Timestamp createdTime;

    @JsonInclude()
    @Transient
    private String sector;

    private long portfolioId;

    @JsonInclude()
    @Transient
    private String portfolioName;

    public PortfolioSecurity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Float getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(Float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }


    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }

    public long getPortfolioId() { return portfolioId; }

    public String getPortfolioName()
    {
        return portfolioName;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}