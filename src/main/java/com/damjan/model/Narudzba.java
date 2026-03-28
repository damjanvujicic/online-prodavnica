package com.damjan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Narudzba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kupac_id")
    private Kupac kupac;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "racun_id")
    private Racun racun;

    @OneToMany(mappedBy = "narudzba", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StavkaNarudzbe> stavke;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Kupac getKupac() { return kupac; }
    public void setKupac(Kupac kupac) { this.kupac = kupac; }

    public Racun getRacun() { return racun; }
    public void setRacun(Racun racun) { this.racun = racun; }

    public List<StavkaNarudzbe> getStavke() { return stavke; }
    public void setStavke(List<StavkaNarudzbe> stavke) { this.stavke = stavke; }
}