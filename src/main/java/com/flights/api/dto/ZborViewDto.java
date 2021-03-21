package com.flights.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

public class ZborViewDto {

    private final int idZbor;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final LocalDateTime dataPlecare;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final LocalDateTime dataSosire;

    private final PilotViewDto pilot;
    private final AvionViewDto avion;
    private final Set<RutaViewDto> rute;

    ZborViewDto(int idZbor, LocalDateTime dataPlecare, LocalDateTime dataSosire, PilotViewDto pilot, AvionViewDto avion, Set<RutaViewDto> rute) {
        this.idZbor = idZbor;
        this.dataPlecare = dataPlecare;
        this.dataSosire = dataSosire;
        this.pilot = pilot;
        this.avion = avion;
        this.rute = rute;
    }

    public static ZborViewDtoBuilder builder() {
        return new ZborViewDtoBuilder();
    }

    public int getIdZbor() {
        return this.idZbor;
    }

    public LocalDateTime getDataPlecare() {
        return this.dataPlecare;
    }

    public LocalDateTime getDataSosire() {
        return this.dataSosire;
    }

    public PilotViewDto getPilot() {
        return this.pilot;
    }

    public AvionViewDto getAvion() {
        return this.avion;
    }

    public Set<RutaViewDto> getRute() {
        return this.rute;
    }

    public static class ZborViewDtoBuilder {
        private int idZbor;
        private LocalDateTime dataPlecare;
        private LocalDateTime dataSosire;
        private PilotViewDto pilot;
        private AvionViewDto avion;
        private Set<RutaViewDto> rute;

        ZborViewDtoBuilder() {
        }

        public ZborViewDtoBuilder idZbor(int idZbor) {
            this.idZbor = idZbor;
            return this;
        }

        public ZborViewDtoBuilder dataPlecare(LocalDateTime dataPlecare) {
            this.dataPlecare = dataPlecare;
            return this;
        }

        public ZborViewDtoBuilder dataSosire(LocalDateTime dataSosire) {
            this.dataSosire = dataSosire;
            return this;
        }

        public ZborViewDtoBuilder pilot(PilotViewDto pilot) {
            this.pilot = pilot;
            return this;
        }

        public ZborViewDtoBuilder avion(AvionViewDto avion) {
            this.avion = avion;
            return this;
        }

        public ZborViewDtoBuilder rute(Set<RutaViewDto> rute) {
            this.rute = rute;
            return this;
        }

        public ZborViewDto build() {
            return new ZborViewDto(idZbor, dataPlecare, dataSosire, pilot, avion, rute);
        }

        public String toString() {
            return "ZborViewDto.ZborViewDtoBuilder(idZbor=" + this.idZbor + ", dataPlecare=" + this.dataPlecare + ", dataSosire=" + this.dataSosire + ", pilot=" + this.pilot + ", avion=" + this.avion + ", rute=" + this.rute + ")";
        }
    }
}
