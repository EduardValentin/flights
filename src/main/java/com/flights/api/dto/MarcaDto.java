package com.flights.api.dto;

public class MarcaDto {

    private int id;

    private String nume;

    public MarcaDto(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public MarcaDto() {
    }

    public static MarcaDtoBuilder builder() {
        return new MarcaDtoBuilder();
    }

    public int getId() {
        return this.id;
    }

    public String getNume() {
        return this.nume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public static class MarcaDtoBuilder {
        private int id;
        private String nume;

        MarcaDtoBuilder() {
        }

        public MarcaDtoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public MarcaDtoBuilder nume(String nume) {
            this.nume = nume;
            return this;
        }

        public MarcaDto build() {
            return new MarcaDto(id, nume);
        }

        public String toString() {
            return "MarcaDto.MarcaDtoBuilder(id=" + this.id + ", nume=" + this.nume + ")";
        }
    }
}
