package com.flights.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "ruta")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ruta_seq")
    @SequenceGenerator(name = "ruta_seq", allocationSize = 1)
    private int idRuta;

    @ManyToOne
    @JoinColumn(name = "id_aeroport_destinatie")
    private Aeroport aeroportDestinatie;

    @ManyToOne
    @JoinColumn(name = "id_aeroport_plecare")
    private Aeroport aeroportPlecare;

    @OneToMany(mappedBy = "zbor")
    private Set<RuteZbor> zboruri;

    public Ruta(int idRuta, Aeroport aeroportDestinatie, Aeroport aeroportPlecare, Set<RuteZbor> zboruri) {
        this.idRuta = idRuta;
        this.aeroportDestinatie = aeroportDestinatie;
        this.aeroportPlecare = aeroportPlecare;
        this.zboruri = zboruri;
    }

    public Ruta() {
    }

    public static RutaBuilder builder() {
        return new RutaBuilder();
    }

    public int getIdRuta() {
        return this.idRuta;
    }

    public Aeroport getAeroportDestinatie() {
        return this.aeroportDestinatie;
    }

    public Aeroport getAeroportPlecare() {
        return this.aeroportPlecare;
    }

    public Set<RuteZbor> getZboruri() {
        return this.zboruri;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setAeroportDestinatie(Aeroport aeroportDestinatie) {
        this.aeroportDestinatie = aeroportDestinatie;
    }

    public void setAeroportPlecare(Aeroport aeroportPlecare) {
        this.aeroportPlecare = aeroportPlecare;
    }

    public void setZboruri(Set<RuteZbor> zboruri) {
        this.zboruri = zboruri;
    }

    public static class RutaBuilder {
        private int idRuta;
        private Aeroport aeroportDestinatie;
        private Aeroport aeroportPlecare;
        private Set<RuteZbor> zboruri;

        RutaBuilder() {
        }

        public RutaBuilder idRuta(int idRuta) {
            this.idRuta = idRuta;
            return this;
        }

        public RutaBuilder aeroportDestinatie(Aeroport aeroportDestinatie) {
            this.aeroportDestinatie = aeroportDestinatie;
            return this;
        }

        public RutaBuilder aeroportPlecare(Aeroport aeroportPlecare) {
            this.aeroportPlecare = aeroportPlecare;
            return this;
        }

        public RutaBuilder zboruri(Set<RuteZbor> zboruri) {
            this.zboruri = zboruri;
            return this;
        }

        public Ruta build() {
            return new Ruta(idRuta, aeroportDestinatie, aeroportPlecare, zboruri);
        }

        public String toString() {
            return "Ruta.RutaBuilder(idRuta=" + this.idRuta + ", aeroportDestinatie=" + this.aeroportDestinatie + ", aeroportPlecare=" + this.aeroportPlecare + ", zboruri=" + this.zboruri + ")";
        }
    }
}
