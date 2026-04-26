package com.damjan.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.ipify.org")
@Path("/")
public interface IpClient {

    @GET
    String getMyIp();
}