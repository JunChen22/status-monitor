package com.junchen.statusmonitor.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EndpointUptimeDTO {

    private String endpointName;

    private List<EndpointDTO> endpointsList;

    private double percentage;

    private String status;

    @Data
    public static class EndpointDTO {
        private double percentage;
        private Date dateRecorded;
    }
}
