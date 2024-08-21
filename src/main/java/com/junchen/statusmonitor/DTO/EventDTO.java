package com.junchen.statusmonitor.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {

    private String action;
    private String description;
    private String dateCreated;

}
