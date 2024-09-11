package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class UpdateEvent {

    public enum EventAction {
        UP,
        DOWN,
        PAUSE
    }

    @Id
    private Long id;

    @Column(nullable = false)
    private Long applicationId;

    @Column(nullable = false)
    private Long endpointId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventAction action; // Enum to represent Up, Down, Pause

    @Column
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

}
