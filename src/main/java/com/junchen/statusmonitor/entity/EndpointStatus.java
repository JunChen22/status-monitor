package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class EndpointStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endpoint_id", nullable = false)
    private Endpoint endpoint;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; // Enum to represent Up, Down, Pause

    @Column(nullable = false)
    private long responseTime; // Response time in milliseconds

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRecorded;

    public enum Status {
        UP, DOWN, PAUSE
    }
}