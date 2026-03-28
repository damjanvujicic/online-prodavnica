package com.damjan.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Racun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brojRacuna;
    private LocalDate datumIzdavanja;
    private double ukupanIznos;
    private double porezStopa;
    private String napomena;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrojRacuna() { return brojRacuna; }
    public void setBrojRacuna(String brojRacuna) { this.brojRacuna = brojRacuna; }

    public LocalDate getDatumIzdavanja() { return datumIzdavanja; }
    public void setDatumIzdavanja(LocalDate datumIzdavanja) { this.datumIzdavanja = datumIzdavanja; }

    public double getUkupanIznos() { return ukupanIznos; }
    public void setUkupanIznos(double ukupanIznos) { this.ukupanIznos = ukupanIznos; }

    public double getPorezStopa() { return porezStopa; }
    public void setPorezStopa(double porezStopa) { this.porezStopa = porezStopa; }

    public String getNapomena() { return napomena; }
    public void setNapomena(String napomena) { this.napomena = napomena; }
}