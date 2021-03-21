package com.flights.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportDto {

    @NotNull
    private Integer idLocatie;

    @NotBlank
    private String denumire;

    public @NotNull Integer getIdLocatie() {
        return this.idLocatie;
    }

    public @NotBlank String getDenumire() {
        return this.denumire;
    }

    public void setIdLocatie(@NotNull Integer idLocatie) {
        this.idLocatie = idLocatie;
    }

    public void setDenumire(@NotBlank String denumire) {
        this.denumire = denumire;
    }
}
