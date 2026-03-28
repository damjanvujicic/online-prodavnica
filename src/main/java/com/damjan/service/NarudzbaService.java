package com.damjan.service;

import com.damjan.model.Kupac;
import com.damjan.model.Narudzba;
import com.damjan.model.StavkaNarudzbe;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class NarudzbaService {

    @Inject
    EntityManager em;

    @Transactional
    public void sacuvajNarudzbu(Narudzba narudzba) {
        if (narudzba.getStavke() != null) {
            for (StavkaNarudzbe stavka : narudzba.getStavke()) {
                stavka.setNarudzba(narudzba);
            }
        }
        if (narudzba.getKupac() != null) {
            Kupac kupac = em.find(Kupac.class, narudzba.getKupac().getId());
            narudzba.setKupac(kupac);
        }
        em.persist(narudzba);
    }

    public List<Narudzba> sveNarudzbe() {
        return em.createQuery("SELECT n FROM Narudzba n", Narudzba.class).getResultList();
    }

    // Pronadji narudzbu po ID-u - @PathParam
    public Narudzba nadjiNarudzbuPoId(Long id) {
        return em.find(Narudzba.class, id);
    }

    // Sve stavke za odredjenu narudzbu - @PathParam
    public List<StavkaNarudzbe> stavkeNarudzbe(Long narudzbaId) {
        return em.createQuery(
                        "SELECT s FROM StavkaNarudzbe s WHERE s.narudzba.id = :narudzbaId", StavkaNarudzbe.class)
                .setParameter("narudzbaId", narudzbaId)
                .getResultList();
    }

    // Pronadji narudzbe po statusu - @QueryParam
    public List<Narudzba> nadjiPoStatusu(String status) {
        return em.createQuery(
                        "SELECT n FROM Narudzba n WHERE n.status = :status", Narudzba.class)
                .setParameter("status", status)
                .getResultList();
    }
}