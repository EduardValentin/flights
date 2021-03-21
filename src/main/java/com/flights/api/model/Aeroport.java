package com.flights.api.model;

import javax.persistence.*;

@Entity(name = "aeroport")
public class Aeroport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aeroport_seq")
    @SequenceGenerator(name = "aeroport_seq", allocationSize = 1)
    private int idAeroport;

    @ManyToOne
    @JoinColumn(name = "id_locatie")
    private Locatie locatie;

    private String denumire;

    public Aeroport(int idAeroport, Locatie locatie, String denumire) {
        this.idAeroport = idAeroport;
        this.locatie = locatie;
        this.denumire = denumire;
    }

    public Aeroport() {
    }

    public static AeroportBuilder builder() {
        return new AeroportBuilder();
    }

    public int getIdAeroport() {
        return this.idAeroport;
    }

    public Locatie getLocatie() {
        return this.locatie;
    }

    public String getDenumire() {
        return this.denumire;
    }

    public void setIdAeroport(int idAeroport) {
        this.idAeroport = idAeroport;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public static class AeroportBuilder {
        private int idAeroport;
        private Locatie locatie;
        private String denumire;

        AeroportBuilder() {
        }

        public AeroportBuilder idAeroport(int idAeroport) {
            this.idAeroport = idAeroport;
            return this;
        }

        public AeroportBuilder locatie(Locatie locatie) {
            this.locatie = locatie;
            return this;
        }

        public AeroportBuilder denumire(String denumire) {
            this.denumire = denumire;
            return this;
        }

        public Aeroport build() {
            return new Aeroport(idAeroport, locatie, denumire);
        }

        public String toString() {
            return "Aeroport.AeroportBuilder(idAeroport=" + this.idAeroport + ", locatie=" + this.locatie + ", denumire=" + this.denumire + ")";
        }
    }
}
