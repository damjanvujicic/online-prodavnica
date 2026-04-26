package com.damjan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class TimeZoneInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String timeZone;
    public String dateTime;
    public String dayOfWeek;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "kupac_id")
    public Kupac kupac;
}