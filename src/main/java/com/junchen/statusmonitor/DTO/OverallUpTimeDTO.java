package com.junchen.statusmonitor.DTO;

import lombok.Data;

@Data
public class OverallUpTimeDTO {

    private double last24HoursUptime;

    private double last7DaysUptime;

    private double last30DaysUptime;

    private double last90DaysUptime;

}
