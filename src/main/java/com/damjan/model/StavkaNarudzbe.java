package com.damjan.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StavkaNarudzbe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int kolicina;
    private double cijena;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "narudzba_id")
    private Narudzba narudzba;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proizvod_id")
    private Proizvod proizvod;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getKolicina() { return kolicina; }
    public void setKolicina(int kolicina) { this.kolicina = kolicina; }

    public double getCijena() { return cijena; }
    public void setCijena(double cijena) { this.cijena = cijena; }

    public Narudzba getNarudzba() { return narudzba; }
    public void setNarudzba(Narudzba narudzba) { this.narudzba = narudzba; }

    public Proizvod getProizvod() { return proizvod; }
    public void setProizvod(Proizvod proizvod) { this.proizvod = proizvod; }
}