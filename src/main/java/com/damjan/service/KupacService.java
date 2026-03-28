package com.damjan.service;

import com.damjan.model.Kupac;
import com.damjan.model.Narudzba;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class KupacService {

    @Inject
    EntityManager em;

    @Transactional
    public void sacuvajKupca(Kupac kupac) {
        if (kupac.getAdresa() != null) {
            em.persist(kupac.getAdresa());
        }
        em.persist(kupac);
    }

    public List<Kupac> sviKupci() {
        return em.createQuery("SELECT k FROM Kupac k", Kupac.class).getResultList();
    }

    // Pronadji kupca po ID-u - @PathParam
    public Kupac nadjiKupcaPoId(Long id) {
        return em.find(Kupac.class, id);
    }

    // Pronadji kupce po gradu - @QueryParam
    public List<Kupac> nadjiKupcePoGradu(String grad) {
        return em.createQuery(
                        "SELECT k FROM Kupac k WHERE k.adresa.grad = :grad", Kupac.class)
                .setParameter("grad", grad)
                .getResultList();
    }

    // Sve narudzbe za odredjenog kupca - @QueryParam
    public List<Narudzba> narudzbeKupca(Long kupacId) {
        return em.createQuery(
                        "SELECT n FROM Narudzba n WHERE n.kupac.id = :kupacId", Narudzba.class)
                .setParameter("kupacId", kupacId)
                .getResultList();
    }
}