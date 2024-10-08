package com.junchen.statusmonitor.service.impl;

import com.junchen.statusmonitor.service.StatusService;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    @Override
    public void visitEndpoint(Long endpointId) {
        System.out.println("Visiting endpoint " + endpointId);
    }
}
