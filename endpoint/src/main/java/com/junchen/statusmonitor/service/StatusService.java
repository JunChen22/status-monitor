package com.junchen.statusmonitor.service;

public interface StatusService {

    // visit the endpoint and store the result, status, reponse time, etc.
    // will be using @Scheduled to visit the endpoint every 1 minute.
    // will change to Quartz for more complex scheduling.
    void visitEndpoint(Long endpointId );


}
