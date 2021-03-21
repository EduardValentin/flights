package com.flights.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateAvionDto {

    @Min(1)
    private double greutateTone;

    @Min(20)
    private int locuriMaxime;

    @NotNull
    private MarcaDto marca;

    public @Min(1) double getGreutateTone() {
        return this.greutateTone;
    }

    public @Min(20) int getLocuriMaxime() {
        return this.locuriMaxime;
    }

    public @NotNull MarcaDto getMarca() {
        return this.marca;
    }

    public void setGreutateTone(@Min(1) double greutateTone) {
        this.greutateTone = greutateTone;
    }

    public void setLocuriMaxime(@Min(20) int locuriMaxime) {
        this.locuriMaxime = locuriMaxime;
    }

    public void setMarca(@NotNull MarcaDto marca) {
        this.marca = marca;
    }
}
