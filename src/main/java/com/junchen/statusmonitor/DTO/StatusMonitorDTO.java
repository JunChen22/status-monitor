package com.junchen.statusmonitor.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StatusMonitorDTO {

    private String applicationName;

    private List<EndpointUptimeDTO> endpointUptime;

    private OverallUpTimeDTO overallUpTime;

    private UpdateEventDTO updateEvent;

}
