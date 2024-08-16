package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Endpoint {

    public enum MonitorType {
        HTTPS,
        KEYWORD,
        PING,
        PORT,
        HEARTBEAT
    }

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Applications application;

    @Column(nullable = false)
    private String endPointName;

    @Column(nullable = false)
    private String endPointUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonitorType monitorType;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private Date dateModified;

}