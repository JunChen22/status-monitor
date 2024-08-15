package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "applications")
@Getter
@Setter
public class Applications {

    @Id
    @SequenceGenerator(name = "applications_id_seq", sequenceName = "applications_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applications_id_seq")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;  // Will be used when user-related features are added

    @Column(name = "application_name", nullable = false)
    private String applicationName;

    @Column(name = "created_at", nullable = false)
    private Date date;

    @Column(name = "modified_at")
    private Date modDate;

    @Column(name = "token", nullable = false)
    private String token;
}