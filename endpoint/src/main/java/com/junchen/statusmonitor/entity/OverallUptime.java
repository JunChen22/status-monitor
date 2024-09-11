package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class OverallUptime {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long applicationId;

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
    private Date dateModified;

}