package com.flights.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "zbor")
public class Zbor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zbor_seq")
    @SequenceGenerator(name = "zbor_seq", allocationSize = 1)
    private int idZbor;

    @ManyToOne
    @JoinColumn(name = "id_status_zbor")
    private StatusZbor statusZbor;

    @ManyToOne
    @JoinColumn(name = "id_program_zbor")
    private ProgramZbor programZbor;

    @ManyToOne
    @JoinColumn(name = "id_pilot")
    private Pilot pilot;

    @ManyToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;

    @OneToMany(mappedBy = "zbor")
    private Set<RuteZbor> rute;

    public Zbor(int idZbor, StatusZbor statusZbor, ProgramZbor programZbor, Pilot pilot, Avion avion, Set<RuteZbor> rute) {
        this.idZbor = idZbor;
        this.statusZbor = statusZbor;
        this.programZbor = programZbor;
        this.pilot = pilot;
        this.avion = avion;
        this.rute = rute;
    }

    public Zbor() {
    }

    public static ZborBuilder builder() {
        return new ZborBuilder();
    }

    public int getIdZbor() {
        return this.idZbor;
    }

    public StatusZbor getStatusZbor() {
        return this.statusZbor;
    }

    public ProgramZbor getProgramZbor() {
        return this.programZbor;
    }

    public Pilot getPilot() {
        return this.pilot;
    }

    public Avion getAvion() {
        return this.avion;
    }

    public Set<RuteZbor> getRute() {
        return this.rute;
    }

    public void setIdZbor(int idZbor) {
        this.idZbor = idZbor;
    }

    public void setStatusZbor(StatusZbor statusZbor) {
        this.statusZbor = statusZbor;
    }

    public void setProgramZbor(ProgramZbor programZbor) {
        this.programZbor = programZbor;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setRute(Set<RuteZbor> rute) {
        this.rute = rute;
    }

    public static class ZborBuilder {
        private int idZbor;
        private StatusZbor statusZbor;
        private ProgramZbor programZbor;
        private Pilot pilot;
        private Avion avion;
        private Set<RuteZbor> rute;

        ZborBuilder() {
        }

        public ZborBuilder idZbor(int idZbor) {
            this.idZbor = idZbor;
            return this;
        }

        public ZborBuilder statusZbor(StatusZbor statusZbor) {
            this.statusZbor = statusZbor;
            return this;
        }

        public ZborBuilder programZbor(ProgramZbor programZbor) {
            this.programZbor = programZbor;
            return this;
        }

        public ZborBuilder pilot(Pilot pilot) {
            this.pilot = pilot;
            return this;
        }

        public ZborBuilder avion(Avion avion) {
            this.avion = avion;
            return this;
        }

        public ZborBuilder rute(Set<RuteZbor> rute) {
            this.rute = rute;
            return this;
        }

        public Zbor build() {
            return new Zbor(idZbor, statusZbor, programZbor, pilot, avion, rute);
        }

        public String toString() {
            return "Zbor.ZborBuilder(idZbor=" + this.idZbor + ", statusZbor=" + this.statusZbor + ", programZbor=" + this.programZbor + ", pilot=" + this.pilot + ", avion=" + this.avion + ", rute=" + this.rute + ")";
        }
    }
}
