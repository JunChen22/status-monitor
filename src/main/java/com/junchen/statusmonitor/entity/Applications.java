package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "applications")
@Getter
@Setter
public class Applications {

    @Id
    @SequenceGenerator(name = "applications_id_seq", sequenceName = "applications_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applications_id_seq")
    private Long id;

    private Long userId;  // Will be used when user-related features are added

    private String applicationName;

    private Date date;

    private List<String> notificationType;

    private Date modDate;

    private String token;
}