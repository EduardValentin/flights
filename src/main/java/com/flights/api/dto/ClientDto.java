package com.flights.api.dto;

import javax.validation.constraints.NotBlank;

public class ClientDto {

    @NotBlank
    private String nume;
    @NotBlank
    private String prenume;
    @NotBlank
    private String cnp;
    @NotBlank
    private String actIdentitate;
    @NotBlank
    private String email;
    @NotBlank
    private String telefon;

    public @NotBlank String getNume() {
        return this.nume;
    }

    public @NotBlank String getPrenume() {
        return this.prenume;
    }

    public @NotBlank String getCnp() {
        return this.cnp;
    }

    public @NotBlank String getActIdentitate() {
        return this.actIdentitate;
    }

    public @NotBlank String getEmail() {
        return this.email;
    }

    public @NotBlank String getTelefon() {
        return this.telefon;
    }

    public void setNume(@NotBlank String nume) {
        this.nume = nume;
    }

    public void setPrenume(@NotBlank String prenume) {
        this.prenume = prenume;
    }

    public void setCnp(@NotBlank String cnp) {
        this.cnp = cnp;
    }

    public void setActIdentitate(@NotBlank String actIdentitate) {
        this.actIdentitate = actIdentitate;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public void setTelefon(@NotBlank String telefon) {
        this.telefon = telefon;
    }
}
