package com.junchen.statusmonitor.service;

import com.junchen.statusmonitor.entity.Endpoint;
import com.junchen.statusmonitor.entity.EndpointStatus;
import com.junchen.statusmonitor.entity.EndpointStatus.Status;
import com.junchen.statusmonitor.repository.EndpointRepository;
import com.junchen.statusmonitor.repository.EndpointStatusRepository;
import com.junchen.statusmonitor.repository.UpdateEventRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;

@Service
public class HealthCheckService {

    private final static Log Logger = LogFactory.getLog(HealthCheckService.class);

    private final EndpointRepository endpointRepository;

    private final EndpointStatusRepository endpointStatusRepository;

    private final UpdateEventRepository updateEventRepository;

    private final WebClient webClient;

    @Value("${service.check.timeout:5000}") // Default timeout to 5 seconds
    private long timeout;

    @Autowired
    public HealthCheckService(EndpointRepository endpointRepository, EndpointStatusRepository endpointStatusRepository,
                              UpdateEventRepository updateEventRepository, WebClient.Builder webClientBuilder) {
        this.endpointRepository = endpointRepository;
        this.endpointStatusRepository = endpointStatusRepository;
        this.updateEventRepository = updateEventRepository;
        this.webClient = webClientBuilder.build();
    }

    // visit the endpoint and store the result, status, response time, etc.
    // will be using @Scheduled to visit the endpoint every 1 minute.
    // will change to Quartz for more complex scheduling.
    @Scheduled(fixedRate = 10000) // Run every 60 seconds
    public void checkAllServices() {
        List<Endpoint> endpoints = endpointRepository.findAll();
        endpoints.forEach(this::checkServiceStatus);
    }

    public void checkServiceStatus(Endpoint endpoint) {
        long startTime = System.currentTimeMillis();
        String url = endpoint.getEndPointUrl();
        String currentStatus = endpoint.getCurrentStatus();

        EndpointStatus endpointStatus = new EndpointStatus();
        endpointStatus.setEndpointId(endpoint.getId());

        Logger.info("Checking service: " + url);

        try {
            webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();  // Blocking call to wait for the response

            long endTime = System.currentTimeMillis();
            handleSuccess(endpointStatus, currentStatus, startTime, endTime);
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            //handleFailure(endpointStatus, e, startTime, endTime);
        }
    }

    private void handleSuccess(EndpointStatus endpointStatus, String response, long startTime, long endTime) {
        long responseTime = endTime - startTime;
        endpointStatus.setStatus(Status.UP);
        endpointStatus.setResponseTime(responseTime);
        endpointStatus.setDateCreated(new Date());

        // update the endpoint's current status if changed
        statusChangeEvent();

        // Persist the status and response time
        endpointStatusRepository.save(endpointStatus);
        System.out.println("Response: " + response + ", Recorded Time: " + responseTime + "ms");
    }

    private void statusChangeEvent() {
        // updateEventRepository
        // i would want to know how long has it been down for
    }

    /*
    private void handleException(MonitoredService monitoredService, WebClientResponseException ex) {
        monitoredService.setStatus(false);
        monitoredService.setResponseTime(-1);
        // Log the error and update the service status in your database
        System.out.println("Service " + monitoredService.getUrl() + " is down. Status code: " + ex.getStatusCode());
    }

    private void handleGenericException(MonitoredService monitoredService, Exception ex) {
        monitoredService.setStatus(false);
        monitoredService.setResponseTime(-1);
        // Log the error and update the service status in your database
        System.out.println("Service " + monitoredService.getUrl() + " is down. Error: " + ex.getMessage());
    }
     */
}
