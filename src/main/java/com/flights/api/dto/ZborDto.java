package com.flights.api.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ZborDto {

    @NotNull
    private LocalDateTime dataPlecare;

    @NotNull
    private LocalDateTime dataSosire;

    @NotNull
    private Integer idAvion;

    @NotNull
    private Integer idPilot;

    @NotNull
    private Integer idRuta;

    public @NotNull LocalDateTime getDataPlecare() {
        return this.dataPlecare;
    }

    public @NotNull LocalDateTime getDataSosire() {
        return this.dataSosire;
    }

    public @NotNull Integer getIdAvion() {
        return this.idAvion;
    }

    public @NotNull Integer getIdPilot() {
        return this.idPilot;
    }

    public @NotNull Integer getIdRuta() {
        return this.idRuta;
    }

    public void setDataPlecare(@NotNull LocalDateTime dataPlecare) {
        this.dataPlecare = dataPlecare;
    }

    public void setDataSosire(@NotNull LocalDateTime dataSosire) {
        this.dataSosire = dataSosire;
    }

    public void setIdAvion(@NotNull Integer idAvion) {
        this.idAvion = idAvion;
    }

    public void setIdPilot(@NotNull Integer idPilot) {
        this.idPilot = idPilot;
    }

    public void setIdRuta(@NotNull Integer idRuta) {
        this.idRuta = idRuta;
    }
}
