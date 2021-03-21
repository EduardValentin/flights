package com.flights.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "locatie")
public class Locatie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idLocatie;

    @OneToMany(mappedBy = "locatie")
    private Set<Aeroport> aeroporturi;

    private String tara;
    private String oras;
    private String adresa;

    public int getIdLocatie() {
        return this.idLocatie;
    }

    public Set<Aeroport> getAeroporturi() {
        return this.aeroporturi;
    }

    public String getTara() {
        return this.tara;
    }

    public String getOras() {
        return this.oras;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public void setIdLocatie(int idLocatie) {
        this.idLocatie = idLocatie;
    }

    public void setAeroporturi(Set<Aeroport> aeroporturi) {
        this.aeroporturi = aeroporturi;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
