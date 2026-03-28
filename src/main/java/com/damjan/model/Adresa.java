package com.damjan.model;

import jakarta.persistence.*;

@Entity
public class Adresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ulica;
    private String grad;
    private String postanskiBroj;
    private String drzava;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUlica() { return ulica; }
    public void setUlica(String ulica) { this.ulica = ulica; }

    public String getGrad() { return grad; }
    public void setGrad(String grad) { this.grad = grad; }

    public String getPostanskiBroj() { return postanskiBroj; }
    public void setPostanskiBroj(String postanskiBroj) { this.postanskiBroj = postanskiBroj; }

    public String getDrzava() { return drzava; }
    public void setDrzava(String drzava) { this.drzava = drzava; }
}