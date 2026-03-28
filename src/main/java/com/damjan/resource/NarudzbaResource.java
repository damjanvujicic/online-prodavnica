package com.damjan.resource;

import com.damjan.model.Narudzba;
import com.damjan.model.StavkaNarudzbe;
import com.damjan.service.NarudzbaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/narudzbe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NarudzbaResource {

    @Inject
    NarudzbaService narudzbaService;

    @POST
    public Response dodajNarudzbu(Narudzba narudzba) {
        narudzbaService.sacuvajNarudzbu(narudzba);
        return Response.status(Response.Status.CREATED).entity(narudzba).build();
    }

    @GET
    public List<Narudzba> sveNarudzbe() {
        return narudzbaService.sveNarudzbe();
    }

    // @PathParam - narudžba po ID-u
    // http://localhost:8080/narudzbe/1
    @GET
    @Path("/{id}")
    public Response narudzbaPoId(@PathParam("id") Long id) {
        Narudzba narudzba = narudzbaService.nadjiNarudzbuPoId(id);
        if (narudzba == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(narudzba).build();
    }

    // @QueryParam - narudžbe po statusu
    // http://localhost:8080/narudzbe/pretraga?status=aktivan
    @GET
    @Path("/pretraga")
    public List<Narudzba> narudzbePoStatusu(@QueryParam("status") String status) {
        return narudzbaService.nadjiPoStatusu(status);
    }

    // Sve stavke za određenu narudžbu
    // http://localhost:8080/narudzbe/1/stavke
    @GET
    @Path("/{id}/stavke")
    public List<StavkaNarudzbe> stavkeNarudzbe(@PathParam("id") Long id) {
        return narudzbaService.stavkeNarudzbe(id);
    }
}