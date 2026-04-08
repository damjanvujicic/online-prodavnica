package com.damjan.resource;

import com.damjan.model.Kupac;
import com.damjan.model.Narudzba;
import com.damjan.service.KupacService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.annotation.security.RolesAllowed;
import java.util.List;

@Path("/kupci")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KupacResource {

    @Inject
    KupacService kupacService;

    @POST
    @RolesAllowed({"admin"})
    public Response dodajKupca(Kupac kupac) {
        kupacService.sacuvajKupca(kupac);
        return Response.status(Response.Status.CREATED).entity(kupac).build();
    }

    @GET
    public List<Kupac> sviKupci() {
        return kupacService.sviKupci();
    }

    // @PathParam - kupac po ID-u
    // http://localhost:8081/kupci/1
    @GET
    @Path("/{id}")
    public Response kupacPoId(@PathParam("id") Long id) {
        Kupac kupac = kupacService.nadjiKupcaPoId(id);
        if (kupac == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(kupac).build();
    }

    // @QueryParam - kupci po gradu
    // http://localhost:8081/kupci/pretraga?grad=Sarajevo
    @GET
    @Path("/pretraga")
    public List<Kupac> kupciPoGradu(@QueryParam("grad") String grad) {
        return kupacService.nadjiKupcePoGradu(grad);
    }

    // Sve narudžbe za određenog kupca
    // http://localhost:8081/kupci/1/narudzbe
    @GET
    @Path("/{id}/narudzbe")
    public List<Narudzba> narudzbeKupca(@PathParam("id") Long id) {
        return kupacService.narudzbeKupca(id);
    }
}