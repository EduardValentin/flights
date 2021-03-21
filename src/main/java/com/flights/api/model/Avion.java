package com.flights.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "AVION")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avion_seq")
    @SequenceGenerator(name = "avion_seq", allocationSize = 1)
    private int idAvion;

    private double greutateTone;
    private int locuriMaxime;

    @ManyToOne
    @JoinColumn(name = "id_marca_avion")
    private MarcaAvion marcaAvion;

    @OneToMany(mappedBy = "avion")
    private Set<Zbor> zboruri;

    @OneToMany(mappedBy = "avion")
    private Set<CapacitateClasa> capacitateClase;

    public Avion(int idAvion, double greutateTone, int locuriMaxime, MarcaAvion marcaAvion, Set<Zbor> zboruri, Set<CapacitateClasa> capacitateClase) {
        this.idAvion = idAvion;
        this.greutateTone = greutateTone;
        this.locuriMaxime = locuriMaxime;
        this.marcaAvion = marcaAvion;
        this.zboruri = zboruri;
        this.capacitateClase = capacitateClase;
    }

    public Avion() {
    }

    public static AvionBuilder builder() {
        return new AvionBuilder();
    }

    public int getIdAvion() {
        return this.idAvion;
    }

    public double getGreutateTone() {
        return this.greutateTone;
    }

    public int getLocuriMaxime() {
        return this.locuriMaxime;
    }

    public MarcaAvion getMarcaAvion() {
        return this.marcaAvion;
    }

    public Set<Zbor> getZboruri() {
        return this.zboruri;
    }

    public Set<CapacitateClasa> getCapacitateClase() {
        return this.capacitateClase;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public void setGreutateTone(double greutateTone) {
        this.greutateTone = greutateTone;
    }

    public void setLocuriMaxime(int locuriMaxime) {
        this.locuriMaxime = locuriMaxime;
    }

    public void setMarcaAvion(MarcaAvion marcaAvion) {
        this.marcaAvion = marcaAvion;
    }

    public void setZboruri(Set<Zbor> zboruri) {
        this.zboruri = zboruri;
    }

    public void setCapacitateClase(Set<CapacitateClasa> capacitateClase) {
        this.capacitateClase = capacitateClase;
    }

    public static class AvionBuilder {
        private int idAvion;
        private double greutateTone;
        private int locuriMaxime;
        private MarcaAvion marcaAvion;
        private Set<Zbor> zboruri;
        private Set<CapacitateClasa> capacitateClase;

        AvionBuilder() {
        }

        public AvionBuilder idAvion(int idAvion) {
            this.idAvion = idAvion;
            return this;
        }

        public AvionBuilder greutateTone(double greutateTone) {
            this.greutateTone = greutateTone;
            return this;
        }

        public AvionBuilder locuriMaxime(int locuriMaxime) {
            this.locuriMaxime = locuriMaxime;
            return this;
        }

        public AvionBuilder marcaAvion(MarcaAvion marcaAvion) {
            this.marcaAvion = marcaAvion;
            return this;
        }

        public AvionBuilder zboruri(Set<Zbor> zboruri) {
            this.zboruri = zboruri;
            return this;
        }

        public AvionBuilder capacitateClase(Set<CapacitateClasa> capacitateClase) {
            this.capacitateClase = capacitateClase;
            return this;
        }

        public Avion build() {
            return new Avion(idAvion, greutateTone, locuriMaxime, marcaAvion, zboruri, capacitateClase);
        }

        public String toString() {
            return "Avion.AvionBuilder(idAvion=" + this.idAvion + ", greutateTone=" + this.greutateTone + ", locuriMaxime=" + this.locuriMaxime + ", marcaAvion=" + this.marcaAvion + ", zboruri=" + this.zboruri + ", capacitateClase=" + this.capacitateClase + ")";
        }
    }
}
