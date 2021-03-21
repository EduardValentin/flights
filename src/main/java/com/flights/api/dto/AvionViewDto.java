package com.flights.api.dto;


public class AvionViewDto {

    private int id = 0;
    private double greutateTone;
    private int locuriMaxime;
    private MarcaDto marca;

    public AvionViewDto(int id, double greutateTone, int locuriMaxime, MarcaDto marca) {
        this.id = id;
        this.greutateTone = greutateTone;
        this.locuriMaxime = locuriMaxime;
        this.marca = marca;
    }

    public AvionViewDto() {
    }

    public static AvionViewDtoBuilder builder() {
        return new AvionViewDtoBuilder();
    }

    public int getId() {
        return this.id;
    }

    public double getGreutateTone() {
        return this.greutateTone;
    }

    public int getLocuriMaxime() {
        return this.locuriMaxime;
    }

    public MarcaDto getMarca() {
        return this.marca;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGreutateTone(double greutateTone) {
        this.greutateTone = greutateTone;
    }

    public void setLocuriMaxime(int locuriMaxime) {
        this.locuriMaxime = locuriMaxime;
    }

    public void setMarca(MarcaDto marca) {
        this.marca = marca;
    }

    public static class AvionViewDtoBuilder {
        private int id;
        private double greutateTone;
        private int locuriMaxime;
        private MarcaDto marca;

        AvionViewDtoBuilder() {
        }

        public AvionViewDtoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public AvionViewDtoBuilder greutateTone(double greutateTone) {
            this.greutateTone = greutateTone;
            return this;
        }

        public AvionViewDtoBuilder locuriMaxime(int locuriMaxime) {
            this.locuriMaxime = locuriMaxime;
            return this;
        }

        public AvionViewDtoBuilder marca(MarcaDto marca) {
            this.marca = marca;
            return this;
        }

        public AvionViewDto build() {
            return new AvionViewDto(id, greutateTone, locuriMaxime, marca);
        }

        public String toString() {
            return "AvionViewDto.AvionViewDtoBuilder(id=" + this.id + ", greutateTone=" + this.greutateTone + ", locuriMaxime=" + this.locuriMaxime + ", marca=" + this.marca + ")";
        }
    }
}
