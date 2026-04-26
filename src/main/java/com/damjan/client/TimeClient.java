package com.damjan.client;

import com.damjan.dto.TimeResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://timeapi.io")
@Path("/api/time/current/ip")
public interface TimeClient {

    @GET
    TimeResponse getTimeByIp(@QueryParam("ipAddress") String ip);
}