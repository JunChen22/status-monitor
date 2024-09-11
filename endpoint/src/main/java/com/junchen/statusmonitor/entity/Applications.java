package com.junchen.statusmonitor.entity;

import com.junchen.statusmonitor.entity.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Applications {

    @Id
    @SequenceGenerator(name = "applications_id_seq", sequenceName = "applications_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applications_id_seq")
    private Long id;

    private Long userId;  // Will be used when user-related features are added

    private String applicationName;

    @Convert(converter = StringListConverter.class)
    private List<String> notificationType;

    private String token;

    private String timezone;

    private Date dateCreated;

    private Date dateModified;

}