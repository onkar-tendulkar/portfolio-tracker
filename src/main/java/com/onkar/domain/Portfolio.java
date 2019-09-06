package com.onkar.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer userId;
    private String name;

    @Column(name = "created_time", insertable=false)
    private Timestamp createdTime;


    Portfolio(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() { return userId;  }
    public void setUserId(Integer userId) {  this.userId = userId; }

    public Timestamp getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
}