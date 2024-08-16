package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class EndpointDailyUptime {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endpoint_id", nullable = false)
    private Endpoint endpoint;

    @Column(nullable = false)
    private Date dateRecorded;

    @Column(nullable = false)
    private double percentage; // Uptime percentage for the day

}