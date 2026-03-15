package com.damjan.resource;

import com.damjan.model.Kupac;
import com.damjan.service.KupacService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/kupci")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KupacResource {

    @Inject
    KupacService kupacService;

    @POST
    public Response dodajKupca(Kupac kupac) {
        kupacService.sacuvajKupca(kupac);
        return Response.status(Response.Status.CREATED).entity(kupac).build();
    }

    @GET
    public List<Kupac> sviKupci() {
        return kupacService.sviKupci();
    }
}