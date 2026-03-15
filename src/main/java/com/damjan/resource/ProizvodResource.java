package com.damjan.resource;

import com.damjan.model.Proizvod;
import com.damjan.service.ProizvodService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/proizvodi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProizvodResource {

    @Inject
    ProizvodService proizvodService;

    @POST
    public Response dodajProizvod(Proizvod proizvod) {
        proizvodService.sacuvajProizvod(proizvod);
        return Response.status(Response.Status.CREATED).entity(proizvod).build();
    }

    @GET
    public List<Proizvod> sviProizvodi() {
        return proizvodService.sviProizvodi();
    }
}