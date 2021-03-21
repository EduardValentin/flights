package com.flights.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "capacitate_clasa")
public class CapacitateClasa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capacitate_clasa_seq")
    @SequenceGenerator(name = "capacitate_clasa_seq", allocationSize = 1)
    private int idCapacitateClasa;

    @ManyToOne
    @JoinColumn(name = "id_clasa")
    private Clasa clasa;

    @ManyToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;

    private int nrLocuri;
}
