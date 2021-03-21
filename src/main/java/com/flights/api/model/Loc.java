package com.flights.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "loc")
public class Loc {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loc_seq")
    @SequenceGenerator(name = "loc_seq", allocationSize = 1)
    private int idLoc;

    @OneToOne
    @JoinColumn(name = "id_avion")
    @JsonIgnore
    private Avion avion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_clasa")
    private Clasa clasa;

    @OneToMany(mappedBy = "loc")
    private Set<Rezervare> rezervari;

    private int nrLoc;

    Loc(int idLoc, Avion avion, Clasa clasa, int nrLoc) {
        this.idLoc = idLoc;
        this.avion = avion;
        this.clasa = clasa;
        this.nrLoc = nrLoc;
    }

    public Loc() {
    }

    public static LocBuilder builder() {
        return new LocBuilder();
    }

    public int getIdLoc() {
        return this.idLoc;
    }

    public Avion getAvion() {
        return this.avion;
    }

    public Clasa getClasa() {
        return this.clasa;
    }

    public int getNrLoc() {
        return this.nrLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    @JsonIgnore
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setClasa(Clasa clasa) {
        this.clasa = clasa;
    }

    public void setNrLoc(int nrLoc) {
        this.nrLoc = nrLoc;
    }

    public static class LocBuilder {
        private int idLoc;
        private Avion avion;
        private Clasa clasa;
        private int nrLoc;

        LocBuilder() {
        }

        public LocBuilder idLoc(int idLoc) {
            this.idLoc = idLoc;
            return this;
        }

        public LocBuilder avion(Avion avion) {
            this.avion = avion;
            return this;
        }

        public LocBuilder clasa(Clasa clasa) {
            this.clasa = clasa;
            return this;
        }

        public LocBuilder nrLoc(int nrLoc) {
            this.nrLoc = nrLoc;
            return this;
        }

        public Loc build() {
            return new Loc(idLoc, avion, clasa, nrLoc);
        }

        public String toString() {
            return "Loc.LocBuilder(idLoc=" + this.idLoc + ", avion=" + this.avion + ", clasa=" + this.clasa + ", nrLoc=" + this.nrLoc + ")";
        }
    }
}
