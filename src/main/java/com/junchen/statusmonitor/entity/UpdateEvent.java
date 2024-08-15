package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UpdateEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endpoint_id", nullable = false)
    private Endpoint endpoint;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventAction action; // Enum to represent Up, Down, Pause

    @Column
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRecorded;

    public enum EventAction {
        UP, DOWN, PAUSE
    }
}
