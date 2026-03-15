package com.damjan.service;

import com.damjan.model.Proizvod;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProizvodService {

    @Inject
    EntityManager em;

    @Transactional
    public void sacuvajProizvod(Proizvod proizvod) {
        em.persist(proizvod);
    }

    public List<Proizvod> sviProizvodi() {
        return em.createQuery("SELECT p FROM Proizvod p", Proizvod.class).getResultList();
    }
}