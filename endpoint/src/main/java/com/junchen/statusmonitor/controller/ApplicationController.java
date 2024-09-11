package com.junchen.statusmonitor.controller;

import com.junchen.statusmonitor.DTO.EventDTO;
import com.junchen.statusmonitor.DTO.UpdateEventDTO;
import com.junchen.statusmonitor.entity.Applications;
import com.junchen.statusmonitor.mapper.DTOMapper;
import com.junchen.statusmonitor.repository.ApplicationsRepository;
import com.junchen.statusmonitor.repository.UpdateEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationController.class);

    private final ApplicationsRepository applicationsRepository;

    private final UpdateEventRepository updateEventRepository;

    private final DTOMapper dtoMapper;

    @Autowired
    public ApplicationController(ApplicationsRepository applicationsRepository, UpdateEventRepository updateEventRepository, DTOMapper dtoMapper) {
        this.applicationsRepository = applicationsRepository;
        this.updateEventRepository = updateEventRepository;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/{id}/events")
    public UpdateEventDTO getStatus(@PathVariable Long id) {
        Applications application = applicationsRepository.findById(id).orElse(new Applications());

        long applicationId  = application.getId();

        UpdateEventDTO updateEventDTO = new UpdateEventDTO();

        List<EventDTO> eventDTOList = dtoMapper.updateEventToDTO(updateEventRepository.findAllByApplicationId(applicationId));
        updateEventDTO.setEvents(eventDTOList);

        return updateEventDTO;
    }
}
