package com.junchen.statusmonitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Endpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Applications application;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private Date dateModified;

}