package com.flights.api.dto;

public class LocViewDto {

    private final int idLoc;
    private final int nrLoc;

    LocViewDto(int idLoc, int nrLoc) {
        this.idLoc = idLoc;
        this.nrLoc = nrLoc;
    }

    public static LocViewDtoBuilder builder() {
        return new LocViewDtoBuilder();
    }

    public int getIdLoc() {
        return this.idLoc;
    }

    public int getNrLoc() {
        return this.nrLoc;
    }

    public static class LocViewDtoBuilder {
        private int idLoc;
        private int nrLoc;

        LocViewDtoBuilder() {
        }

        public LocViewDtoBuilder idLoc(int idLoc) {
            this.idLoc = idLoc;
            return this;
        }

        public LocViewDtoBuilder nrLoc(int nrLoc) {
            this.nrLoc = nrLoc;
            return this;
        }

        public LocViewDto build() {
            return new LocViewDto(idLoc, nrLoc);
        }

        public String toString() {
            return "LocViewDto.LocViewDtoBuilder(idLoc=" + this.idLoc + ", nrLoc=" + this.nrLoc + ")";
        }
    }
}
