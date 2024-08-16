package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class OverallUptime {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Applications application;

    @Column(nullable = false)
    private double last24HoursUptime;

    @Column(nullable = false)
    private double last7DaysUptime;

    @Column(nullable = false)
    private double last30DaysUptime;

    @Column(nullable = false)
    private double last90DaysUptime;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCalculated;

}