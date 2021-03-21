package com.flights.api.dto;

import java.time.LocalDateTime;

public class PilotViewDto {

    private final int idPilot;
    private final String nume;
    private final String prenume;
    private final String cnp;
    private final String actIdentitate;
    private final String licentaZbor;
    private final int nrOreZbor;
    private final LocalDateTime dataLicenta;

    PilotViewDto(int idPilot, String nume, String prenume, String cnp, String actIdentitate, String licentaZbor, int nrOreZbor, LocalDateTime dataLicenta) {
        this.idPilot = idPilot;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.actIdentitate = actIdentitate;
        this.licentaZbor = licentaZbor;
        this.nrOreZbor = nrOreZbor;
        this.dataLicenta = dataLicenta;
    }

    public static PilotViewDtoBuilder builder() {
        return new PilotViewDtoBuilder();
    }

    public int getIdPilot() {
        return this.idPilot;
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

    public String getLicentaZbor() {
        return this.licentaZbor;
    }

    public int getNrOreZbor() {
        return this.nrOreZbor;
    }

    public LocalDateTime getDataLicenta() {
        return this.dataLicenta;
    }

    public static class PilotViewDtoBuilder {
        private int idPilot;
        private String nume;
        private String prenume;
        private String cnp;
        private String actIdentitate;
        private String licentaZbor;
        private int nrOreZbor;
        private LocalDateTime dataLicenta;

        PilotViewDtoBuilder() {
        }

        public PilotViewDtoBuilder idPilot(int idPilot) {
            this.idPilot = idPilot;
            return this;
        }

        public PilotViewDtoBuilder nume(String nume) {
            this.nume = nume;
            return this;
        }

        public PilotViewDtoBuilder prenume(String prenume) {
            this.prenume = prenume;
            return this;
        }

        public PilotViewDtoBuilder cnp(String cnp) {
            this.cnp = cnp;
            return this;
        }

        public PilotViewDtoBuilder actIdentitate(String actIdentitate) {
            this.actIdentitate = actIdentitate;
            return this;
        }

        public PilotViewDtoBuilder licentaZbor(String licentaZbor) {
            this.licentaZbor = licentaZbor;
            return this;
        }

        public PilotViewDtoBuilder nrOreZbor(int nrOreZbor) {
            this.nrOreZbor = nrOreZbor;
            return this;
        }

        public PilotViewDtoBuilder dataLicenta(LocalDateTime dataLicenta) {
            this.dataLicenta = dataLicenta;
            return this;
        }

        public PilotViewDto build() {
            return new PilotViewDto(idPilot, nume, prenume, cnp, actIdentitate, licentaZbor, nrOreZbor, dataLicenta);
        }

        public String toString() {
            return "PilotViewDto.PilotViewDtoBuilder(idPilot=" + this.idPilot + ", nume=" + this.nume + ", prenume=" + this.prenume + ", cnp=" + this.cnp + ", actIdentitate=" + this.actIdentitate + ", licentaZbor=" + this.licentaZbor + ", nrOreZbor=" + this.nrOreZbor + ", dataLicenta=" + this.dataLicenta + ")";
        }
    }
}
