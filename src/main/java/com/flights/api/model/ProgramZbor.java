package com.flights.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "program_zbor")
public class ProgramZbor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_zbor_seq")
    @SequenceGenerator(name = "program_zbor_seq", allocationSize = 1)
    private int idProgramZbor;

    private LocalDateTime timpPlecare;
    private LocalDateTime timpSosire;

    @OneToMany(mappedBy = "programZbor")
    private Set<Zbor> zboruri;

    public ProgramZbor(int idProgramZbor, LocalDateTime timpPlecare, LocalDateTime timpSosire, Set<Zbor> zboruri) {
        this.idProgramZbor = idProgramZbor;
        this.timpPlecare = timpPlecare;
        this.timpSosire = timpSosire;
        this.zboruri = zboruri;
    }

    public ProgramZbor() {
    }

    public static ProgramZborBuilder builder() {
        return new ProgramZborBuilder();
    }

    public int getIdProgramZbor() {
        return this.idProgramZbor;
    }

    public LocalDateTime getTimpPlecare() {
        return this.timpPlecare;
    }

    public LocalDateTime getTimpSosire() {
        return this.timpSosire;
    }

    public Set<Zbor> getZboruri() {
        return this.zboruri;
    }

    public void setIdProgramZbor(int idProgramZbor) {
        this.idProgramZbor = idProgramZbor;
    }

    public void setTimpPlecare(LocalDateTime timpPlecare) {
        this.timpPlecare = timpPlecare;
    }

    public void setTimpSosire(LocalDateTime timpSosire) {
        this.timpSosire = timpSosire;
    }

    public void setZboruri(Set<Zbor> zboruri) {
        this.zboruri = zboruri;
    }

    public static class ProgramZborBuilder {
        private int idProgramZbor;
        private LocalDateTime timpPlecare;
        private LocalDateTime timpSosire;
        private Set<Zbor> zboruri;

        ProgramZborBuilder() {
        }

        public ProgramZborBuilder idProgramZbor(int idProgramZbor) {
            this.idProgramZbor = idProgramZbor;
            return this;
        }

        public ProgramZborBuilder timpPlecare(LocalDateTime timpPlecare) {
            this.timpPlecare = timpPlecare;
            return this;
        }

        public ProgramZborBuilder timpSosire(LocalDateTime timpSosire) {
            this.timpSosire = timpSosire;
            return this;
        }

        public ProgramZborBuilder zboruri(Set<Zbor> zboruri) {
            this.zboruri = zboruri;
            return this;
        }

        public ProgramZbor build() {
            return new ProgramZbor(idProgramZbor, timpPlecare, timpSosire, zboruri);
        }

        public String toString() {
            return "ProgramZbor.ProgramZborBuilder(idProgramZbor=" + this.idProgramZbor + ", timpPlecare=" + this.timpPlecare + ", timpSosire=" + this.timpSosire + ", zboruri=" + this.zboruri + ")";
        }
    }
}
