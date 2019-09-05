package com.onkar.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Security {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String symbol;
    private String name;

    @Column(name = "created_time", insertable=false)
    private Timestamp createdTime;

    Security(){}

    public Security(String symbol,String name)
    {
        this.symbol = symbol;
        this.name = name;
    }

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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
}