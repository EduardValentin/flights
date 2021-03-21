package com.flights.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Entity(name = "clasa")
public class Clasa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clasa_seq")
    @SequenceGenerator(name = "clasa_seq", allocationSize = 1)
    private int idClasa;

    @OneToMany(mappedBy = "clasa")
    @JsonIgnore
    private Set<CapacitateClasa> capacitateClase;

    private String denumire;
}
