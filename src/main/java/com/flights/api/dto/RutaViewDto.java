package com.flights.api.dto;

public class RutaViewDto {

    private final int idRuta;
    private final AeroportViewDto aeroportPlecare;
    private final AeroportViewDto aeroportDestinatie;

    RutaViewDto(int idRuta, AeroportViewDto aeroportPlecare, AeroportViewDto aeroportDestinatie) {
        this.idRuta = idRuta;
        this.aeroportPlecare = aeroportPlecare;
        this.aeroportDestinatie = aeroportDestinatie;
    }

    public static RutaViewDtoBuilder builder() {
        return new RutaViewDtoBuilder();
    }

    public int getIdRuta() {
        return this.idRuta;
    }

    public AeroportViewDto getAeroportPlecare() {
        return this.aeroportPlecare;
    }

    public AeroportViewDto getAeroportDestinatie() {
        return this.aeroportDestinatie;
    }

    public static class RutaViewDtoBuilder {
        private int idRuta;
        private AeroportViewDto aeroportPlecare;
        private AeroportViewDto aeroportDestinatie;

        RutaViewDtoBuilder() {
        }

        public RutaViewDtoBuilder idRuta(int idRuta) {
            this.idRuta = idRuta;
            return this;
        }

        public RutaViewDtoBuilder aeroportPlecare(AeroportViewDto aeroportPlecare) {
            this.aeroportPlecare = aeroportPlecare;
            return this;
        }

        public RutaViewDtoBuilder aeroportDestinatie(AeroportViewDto aeroportDestinatie) {
            this.aeroportDestinatie = aeroportDestinatie;
            return this;
        }

        public RutaViewDto build() {
            return new RutaViewDto(idRuta, aeroportPlecare, aeroportDestinatie);
        }

        public String toString() {
            return "RutaViewDto.RutaViewDtoBuilder(idRuta=" + this.idRuta + ", aeroportPlecare=" + this.aeroportPlecare + ", aeroportDestinatie=" + this.aeroportDestinatie + ")";
        }
    }
}
