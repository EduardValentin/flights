package com.flights.api.dto;

import javax.validation.constraints.NotNull;

public class RutaDto {

    @NotNull
    private Integer idAeroportPlecare;

    @NotNull
    private Integer idAeroportSosire;

    public @NotNull Integer getIdAeroportPlecare() {
        return this.idAeroportPlecare;
    }

    public @NotNull Integer getIdAeroportSosire() {
        return this.idAeroportSosire;
    }

    public void setIdAeroportPlecare(@NotNull Integer idAeroportPlecare) {
        this.idAeroportPlecare = idAeroportPlecare;
    }

    public void setIdAeroportSosire(@NotNull Integer idAeroportSosire) {
        this.idAeroportSosire = idAeroportSosire;
    }
}
