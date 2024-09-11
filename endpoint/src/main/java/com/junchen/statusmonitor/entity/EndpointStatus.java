package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class EndpointStatus {

    public enum Status {
        UP,
        DOWN,
        PAUSE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long endpointId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; // Enum to represent Up, Down, Pause

    @Column(nullable = false)
    private long responseTime; // Response time in milliseconds

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

}