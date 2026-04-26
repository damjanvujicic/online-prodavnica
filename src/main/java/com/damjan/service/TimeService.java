package com.damjan.service;

import com.damjan.client.IpClient;
import com.damjan.client.TimeClient;
import com.damjan.dto.TimeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class TimeService {

    @Inject
    @RestClient
    IpClient ipClient;

    @Inject
    @RestClient
    TimeClient timeClient;

    public TimeResponse getTime() {
        String ip = ipClient.getMyIp();
        return timeClient.getTimeByIp(ip);
    }
}