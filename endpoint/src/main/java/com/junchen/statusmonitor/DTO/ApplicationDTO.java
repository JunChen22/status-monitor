package com.junchen.statusmonitor.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApplicationDTO {

    private String applicationName;

    private List<String> notificationType;

    private String token;

    private String timezone;

}
