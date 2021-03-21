package com.flights.api.model;

import javax.persistence.*;

@Entity(name = "rute_zbor")
public class RuteZbor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rute_zbor_seq")
    @SequenceGenerator(name = "rute_zbor_seq", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_zbor")
    private Zbor zbor;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    public int getId() {
        return this.id;
    }

    public Zbor getZbor() {
        return this.zbor;
    }

    public Ruta getRuta() {
        return this.ruta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZbor(Zbor zbor) {
        this.zbor = zbor;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
