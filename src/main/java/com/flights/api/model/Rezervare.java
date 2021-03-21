package com.flights.api.model;

import javax.persistence.*;

@Entity(name = "rezervare")
public class Rezervare {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rezervare_seq")
    @SequenceGenerator(name = "rezervare_seq", allocationSize = 1)
    private int idRezervare;

    @ManyToOne
    @JoinColumn(name = "id_zbor")
    private Zbor zbor;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "id_loc")
    private Loc loc;

    private double pret;
    private double discount;
    private String status;

    public Rezervare(int idRezervare, Zbor zbor, Client client, Avion avion, Loc loc, double pret, double discount, String status) {
        this.idRezervare = idRezervare;
        this.zbor = zbor;
        this.client = client;
        this.avion = avion;
        this.loc = loc;
        this.pret = pret;
        this.discount = discount;
        this.status = status;
    }

    public Rezervare() {
    }

    public static RezervareBuilder builder() {
        return new RezervareBuilder();
    }

    public int getIdRezervare() {
        return this.idRezervare;
    }

    public Zbor getZbor() {
        return this.zbor;
    }

    public Client getClient() {
        return this.client;
    }

    public Avion getAvion() {
        return this.avion;
    }

    public Loc getLoc() {
        return this.loc;
    }

    public double getPret() {
        return this.pret;
    }

    public double getDiscount() {
        return this.discount;
    }

    public String getStatus() {
        return this.status;
    }

    public void setIdRezervare(int idRezervare) {
        this.idRezervare = idRezervare;
    }

    public void setZbor(Zbor zbor) {
        this.zbor = zbor;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setLoc(Loc loc) {
        this.loc = loc;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class RezervareBuilder {
        private int idRezervare;
        private Zbor zbor;
        private Client client;
        private Avion avion;
        private Loc loc;
        private double pret;
        private double discount;
        private String status;

        RezervareBuilder() {
        }

        public RezervareBuilder idRezervare(int idRezervare) {
            this.idRezervare = idRezervare;
            return this;
        }

        public RezervareBuilder zbor(Zbor zbor) {
            this.zbor = zbor;
            return this;
        }

        public RezervareBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public RezervareBuilder avion(Avion avion) {
            this.avion = avion;
            return this;
        }

        public RezervareBuilder loc(Loc loc) {
            this.loc = loc;
            return this;
        }

        public RezervareBuilder pret(double pret) {
            this.pret = pret;
            return this;
        }

        public RezervareBuilder discount(double discount) {
            this.discount = discount;
            return this;
        }

        public RezervareBuilder status(String status) {
            this.status = status;
            return this;
        }

        public Rezervare build() {
            return new Rezervare(idRezervare, zbor, client, avion, loc, pret, discount, status);
        }

        public String toString() {
            return "Rezervare.RezervareBuilder(idRezervare=" + this.idRezervare + ", zbor=" + this.zbor + ", client=" + this.client + ", avion=" + this.avion + ", loc=" + this.loc + ", pret=" + this.pret + ", discount=" + this.discount + ", status=" + this.status + ")";
        }
    }
}
