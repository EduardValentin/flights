package com.flights.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "pilot")
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPilot;

    private String nume;
    private String prenume;
    private String cnp;
    private String actIdentitate;
    private int nrOreZbor;
    private String licentaZbor;
    private LocalDateTime dataLicenta;

    @OneToMany(mappedBy = "pilot")
    private Set<Zbor> zboruri;

    public int getIdPilot() {
        return this.idPilot;
    }

    public String getNume() {
        return this.nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public String getCnp() {
        return this.cnp;
    }

    public String getActIdentitate() {
        return this.actIdentitate;
    }

    public int getNrOreZbor() {
        return this.nrOreZbor;
    }

    public String getLicentaZbor() {
        return this.licentaZbor;
    }

    public LocalDateTime getDataLicenta() {
        return this.dataLicenta;
    }

    public Set<Zbor> getZboruri() {
        return this.zboruri;
    }

    public void setIdPilot(int idPilot) {
        this.idPilot = idPilot;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void setActIdentitate(String actIdentitate) {
        this.actIdentitate = actIdentitate;
    }

    public void setNrOreZbor(int nrOreZbor) {
        this.nrOreZbor = nrOreZbor;
    }

    public void setLicentaZbor(String licentaZbor) {
        this.licentaZbor = licentaZbor;
    }

    public void setDataLicenta(LocalDateTime dataLicenta) {
        this.dataLicenta = dataLicenta;
    }

    public void setZboruri(Set<Zbor> zboruri) {
        this.zboruri = zboruri;
    }
}
