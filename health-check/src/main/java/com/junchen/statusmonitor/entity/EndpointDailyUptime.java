package com.junchen.statusmonitor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class EndpointDailyUptime {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long endpointId;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private double percentage; // Uptime percentage for the day

}