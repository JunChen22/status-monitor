package com.junchen.statusmonitor.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EndpointUptimeDTO {

    @Data
    public static class EndpointDTO {
        private double percentage;
        private Date dateRecorded;
    }

    private String endpointName;

    private List<EndpointDTO> endpointsStatusList;

    private double percentage;

    private String status;

}
