package com.junchen.statusmonitor.service;

import com.junchen.statusmonitor.entity.Endpoint;
import com.junchen.statusmonitor.entity.EndpointStatus;
import com.junchen.statusmonitor.entity.EndpointStatus.Status;
import com.junchen.statusmonitor.repository.EndpointRepository;
import com.junchen.statusmonitor.repository.EndpointStatusRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;

@Service
public class RestHealth {

    private final static Log Logger = LogFactory.getLog(RestHealth.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EndpointStatusRepository endpointStatusRepository;

    @Autowired
    private  EndpointRepository endpointRepository;

    public void checkAllServices() {

        List<Endpoint> endpoints = endpointRepository.findAll();
        endpoints.forEach(this::checkServiceStatus);

    }

    public void checkServiceStatus(Endpoint endpoint) {
        long startTime = System.currentTimeMillis();
        String url = endpoint.getEndPointUrl();

        EndpointStatus endpointStatus = new EndpointStatus();
        endpointStatus.setEndpointId(endpoint.getId());

        Logger.info("Checking service: " + url);

        try {
            String response = restTemplate.getForObject(url, String.class);
            long endTime = System.currentTimeMillis();
            handleSuccess(endpointStatus, response, startTime, endTime);
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            handleFailure(endpointStatus, e, startTime, endTime);
        }
    }

    private void handleSuccess(EndpointStatus endpointStatus, String response, long startTime, long endTime) {
        long responseTime = endTime - startTime;
        endpointStatus.setStatus(Status.UP);
        endpointStatus.setResponseTime(responseTime);
        endpointStatus.setDateCreated(new Date());

        // Log for debugging
        Logger.info("Response: " + response + ", Recorded Time: " + responseTime + "ms");

        // Persist the status and response time
        endpointStatusRepository.save(endpointStatus);
    }

    private void handleFailure(EndpointStatus endpointStatus, Exception e, long startTime, long endTime) {
        long responseTime = endTime - startTime;
        endpointStatus.setStatus(Status.DOWN);
        endpointStatus.setResponseTime(responseTime);
        endpointStatus.setDateCreated(new Date());

        // Log error and store status
        Logger.error("Error: " + e.getMessage() + ", Response Time: " + responseTime + "ms");
        endpointStatusRepository.save(endpointStatus);
    }
}
