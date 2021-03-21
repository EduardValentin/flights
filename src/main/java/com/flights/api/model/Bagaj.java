package com.flights.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "bagaj")
public class Bagaj {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bagaj_seq")
    @SequenceGenerator(name = "bagaj_seq", allocationSize = 1)
    private int idBagaj;

    @ManyToOne
    @JoinColumn(name = "id_rezervare")
    private Rezervare rezervare;

    private String status;
}
