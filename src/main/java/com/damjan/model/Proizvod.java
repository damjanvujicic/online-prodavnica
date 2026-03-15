package com.damjan.model;

import jakarta.persistence.*;

@Entity
public class Proizvod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String opis;
    private double cijena;
    private int kolicinaNaSkladistu;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }

    public double getCijena() { return cijena; }
    public void setCijena(double cijena) { this.cijena = cijena; }

    public int getKolicinaNaSkladistu() { return kolicinaNaSkladistu; }
    public void setKolicinaNaSkladistu(int kolicinaNaSkladistu) { this.kolicinaNaSkladistu = kolicinaNaSkladistu; }
}