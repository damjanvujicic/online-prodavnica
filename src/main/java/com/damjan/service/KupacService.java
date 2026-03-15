package com.damjan.service;

import com.damjan.model.Kupac;
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
        em.persist(kupac);
    }

    public List<Kupac> sviKupci() {
        return em.createQuery("SELECT k FROM Kupac k", Kupac.class).getResultList();
    }
}