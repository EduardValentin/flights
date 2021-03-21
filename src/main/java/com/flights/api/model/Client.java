package com.flights.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", allocationSize = 1)
    private int idClient;

    @OneToMany(mappedBy = "client")
    private Set<Rezervare> rezervari;

    private String nume;
    private String prenume;
    private String cnp;
    private String actIdentitate;
    private String email;
    private String telefon;

    public Client(int idClient, Set<Rezervare> rezervari, String nume, String prenume, String cnp, String actIdentitate, String email, String telefon) {
        this.idClient = idClient;
        this.rezervari = rezervari;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.actIdentitate = actIdentitate;
        this.email = email;
        this.telefon = telefon;
    }

    public Client() {
    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    public int getIdClient() {
        return this.idClient;
    }

    public Set<Rezervare> getRezervari() {
        return this.rezervari;
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

    public String getEmail() {
        return this.email;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setRezervari(Set<Rezervare> rezervari) {
        this.rezervari = rezervari;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public static class ClientBuilder {
        private int idClient;
        private Set<Rezervare> rezervari;
        private String nume;
        private String prenume;
        private String cnp;
        private String actIdentitate;
        private String email;
        private String telefon;

        ClientBuilder() {
        }

        public ClientBuilder idClient(int idClient) {
            this.idClient = idClient;
            return this;
        }

        public ClientBuilder rezervari(Set<Rezervare> rezervari) {
            this.rezervari = rezervari;
            return this;
        }

        public ClientBuilder nume(String nume) {
            this.nume = nume;
            return this;
        }

        public ClientBuilder prenume(String prenume) {
            this.prenume = prenume;
            return this;
        }

        public ClientBuilder cnp(String cnp) {
            this.cnp = cnp;
            return this;
        }

        public ClientBuilder actIdentitate(String actIdentitate) {
            this.actIdentitate = actIdentitate;
            return this;
        }

        public ClientBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder telefon(String telefon) {
            this.telefon = telefon;
            return this;
        }

        public Client build() {
            return new Client(idClient, rezervari, nume, prenume, cnp, actIdentitate, email, telefon);
        }

        public String toString() {
            return "Client.ClientBuilder(idClient=" + this.idClient + ", rezervari=" + this.rezervari + ", nume=" + this.nume + ", prenume=" + this.prenume + ", cnp=" + this.cnp + ", actIdentitate=" + this.actIdentitate + ", email=" + this.email + ", telefon=" + this.telefon + ")";
        }
    }
}
