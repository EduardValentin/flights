package com.flights.api.dto;

public class AeroportViewDto {

    private final int idAeroport;
    private final String denumire;
    private final LocatieDto locatie;

    AeroportViewDto(int idAeroport, String denumire, LocatieDto locatie) {
        this.idAeroport = idAeroport;
        this.denumire = denumire;
        this.locatie = locatie;
    }

    public static AeroportViewDtoBuilder builder() {
        return new AeroportViewDtoBuilder();
    }

    public int getIdAeroport() {
        return this.idAeroport;
    }

    public String getDenumire() {
        return this.denumire;
    }

    public LocatieDto getLocatie() {
        return this.locatie;
    }

    public static class AeroportViewDtoBuilder {
        private int idAeroport;
        private String denumire;
        private LocatieDto locatie;

        AeroportViewDtoBuilder() {
        }

        public AeroportViewDtoBuilder idAeroport(int idAeroport) {
            this.idAeroport = idAeroport;
            return this;
        }

        public AeroportViewDtoBuilder denumire(String denumire) {
            this.denumire = denumire;
            return this;
        }

        public AeroportViewDtoBuilder locatie(LocatieDto locatie) {
            this.locatie = locatie;
            return this;
        }

        public AeroportViewDto build() {
            return new AeroportViewDto(idAeroport, denumire, locatie);
        }

        public String toString() {
            return "AeroportViewDto.AeroportViewDtoBuilder(idAeroport=" + this.idAeroport + ", denumire=" + this.denumire + ", locatie=" + this.locatie + ")";
        }
    }
}
