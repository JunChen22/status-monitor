package com.junchen.statusmonitor.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateEventDTO  {

    private List<EventDTO> events;

}
