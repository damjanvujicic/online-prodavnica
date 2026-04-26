package com.damjan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Kupac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;
    private String email;
    private String telefon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresa_id")
    private Adresa adresa;

    @JsonIgnore
    @OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Narudzba> narudzbe;

    @OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<TimeZoneInfo> timeZones = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public Adresa getAdresa() { return adresa; }
    public void setAdresa(Adresa adresa) { this.adresa = adresa; }
}

