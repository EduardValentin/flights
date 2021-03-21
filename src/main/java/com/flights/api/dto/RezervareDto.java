package com.flights.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RezervareDto {

    @NotNull
    private Integer idZbor;

    @NotNull
    private ClientDto client;

    @NotNull
    private Integer idAvion;

    @NotNull
    private Integer idLoc;

    @NotNull
    private Double pret;

    @NotNull
    private Double discount;

    @NotBlank
    private String status;

    public @NotNull Integer getIdZbor() {
        return this.idZbor;
    }

    public @NotNull ClientDto getClient() {
        return this.client;
    }

    public @NotNull Integer getIdAvion() {
        return this.idAvion;
    }

    public @NotNull Integer getIdLoc() {
        return this.idLoc;
    }

    public @NotNull Double getPret() {
        return this.pret;
    }

    public @NotNull Double getDiscount() {
        return this.discount;
    }

    public @NotBlank String getStatus() {
        return this.status;
    }

    public void setIdZbor(@NotNull Integer idZbor) {
        this.idZbor = idZbor;
    }

    public void setClient(@NotNull ClientDto client) {
        this.client = client;
    }

    public void setIdAvion(@NotNull Integer idAvion) {
        this.idAvion = idAvion;
    }

    public void setIdLoc(@NotNull Integer idLoc) {
        this.idLoc = idLoc;
    }

    public void setPret(@NotNull Double pret) {
        this.pret = pret;
    }

    public void setDiscount(@NotNull Double discount) {
        this.discount = discount;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }
}
