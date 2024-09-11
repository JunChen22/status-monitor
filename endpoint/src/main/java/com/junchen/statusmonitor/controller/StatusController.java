package com.junchen.statusmonitor.controller;

import com.junchen.statusmonitor.repository.ApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ApplicationsRepository applicationsRepository;

    @Autowired
    public StatusController(ApplicationsRepository applicationsRepository) {
        this.applicationsRepository = applicationsRepository;
    }

    @GetMapping("/test")
    public List<String> test() {
        return applicationsRepository.findById((long) 1).getNotificationType();
    }
}
