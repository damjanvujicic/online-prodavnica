package com.damjan.scheduler;

import com.damjan.model.Proizvod;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SkladisteScheduler {

    @Inject
    EntityManager em;

    @Scheduled(every = "30s")
    @Transactional
    public void provjeriSkladiste() {
        List<Proizvod> nedostupni = em.createQuery(
                        "SELECT p FROM Proizvod p WHERE p.kolicinaNaSkladistu = 0", Proizvod.class)
                .getResultList();

        if (nedostupni.isEmpty()) {
            System.out.println("✔ Svi proizvodi su dostupni na skladištu.");
        } else {
            System.out.println("⚠ Proizvodi koji nisu dostupni na skladištu:");
            for (Proizvod p : nedostupni) {
                System.out.println("  - " + p.getNaziv() + " (ID: " + p.getId() + ")");
            }
        }
    }
}