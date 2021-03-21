package com.flights.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "status_zbor")
public class StatusZbor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idStatusZbor;

    private String status;

    @OneToMany(mappedBy = "statusZbor")
    private Set<Zbor> zboruri;

    public int getIdStatusZbor() {
        return this.idStatusZbor;
    }

    public String getStatus() {
        return this.status;
    }

    public Set<Zbor> getZboruri() {
        return this.zboruri;
    }

    public void setIdStatusZbor(int idStatusZbor) {
        this.idStatusZbor = idStatusZbor;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setZboruri(Set<Zbor> zboruri) {
        this.zboruri = zboruri;
    }
}
