package com.flights.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "MARCA_AVION")
public class MarcaAvion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMarcaAvion;

    private String nume;

    @JsonIgnore
    @OneToMany(mappedBy = "marcaAvion")
    private Set<Avion> avioane;

    public int getIdMarcaAvion() {
        return this.idMarcaAvion;
    }

    public String getNume() {
        return this.nume;
    }

    public Set<Avion> getAvioane() {
        return this.avioane;
    }

    public void setIdMarcaAvion(int idMarcaAvion) {
        this.idMarcaAvion = idMarcaAvion;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @JsonIgnore
    public void setAvioane(Set<Avion> avioane) {
        this.avioane = avioane;
    }
}
