package com.junchen.statusmonitor.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UpdateEventDTO {

    private List<EventDTO> events;

    @Data
    public static class EventDTO {
        private String action;
        private String description;
        private String dateRecorded;
    }
}
