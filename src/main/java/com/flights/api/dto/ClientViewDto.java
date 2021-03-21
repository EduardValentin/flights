package com.flights.api.dto;

public class ClientViewDto {

    private final int idClient;
    private final String nume;
    private final String prenume;
    private final String cnp;
    private final String actIdentitate;
    private final String email;
    private final String telefon;

    ClientViewDto(int idClient, String nume, String prenume, String cnp, String actIdentitate, String email, String telefon) {
        this.idClient = idClient;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.actIdentitate = actIdentitate;
        this.email = email;
        this.telefon = telefon;
    }

    public static ClientViewDtoBuilder builder() {
        return new ClientViewDtoBuilder();
    }

    public int getIdClient() {
        return this.idClient;
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

    public static class ClientViewDtoBuilder {
        private int idClient;
        private String nume;
        private String prenume;
        private String cnp;
        private String actIdentitate;
        private String email;
        private String telefon;

        ClientViewDtoBuilder() {
        }

        public ClientViewDtoBuilder idClient(int idClient) {
            this.idClient = idClient;
            return this;
        }

        public ClientViewDtoBuilder nume(String nume) {
            this.nume = nume;
            return this;
        }

        public ClientViewDtoBuilder prenume(String prenume) {
            this.prenume = prenume;
            return this;
        }

        public ClientViewDtoBuilder cnp(String cnp) {
            this.cnp = cnp;
            return this;
        }

        public ClientViewDtoBuilder actIdentitate(String actIdentitate) {
            this.actIdentitate = actIdentitate;
            return this;
        }

        public ClientViewDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ClientViewDtoBuilder telefon(String telefon) {
            this.telefon = telefon;
            return this;
        }

        public ClientViewDto build() {
            return new ClientViewDto(idClient, nume, prenume, cnp, actIdentitate, email, telefon);
        }

        public String toString() {
            return "ClientViewDto.ClientViewDtoBuilder(idClient=" + this.idClient + ", nume=" + this.nume + ", prenume=" + this.prenume + ", cnp=" + this.cnp + ", actIdentitate=" + this.actIdentitate + ", email=" + this.email + ", telefon=" + this.telefon + ")";
        }
    }
}
