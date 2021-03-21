package com.flights.api.dto;

public class LocatieDto {

    private int idLocatie;
    private String tara;
    private String oras;
    private String adresa;

    public LocatieDto(int idLocatie, String tara, String oras, String adresa) {
        this.idLocatie = idLocatie;
        this.tara = tara;
        this.oras = oras;
        this.adresa = adresa;
    }

    public LocatieDto() {
    }

    public static LocatieDtoBuilder builder() {
        return new LocatieDtoBuilder();
    }

    public int getIdLocatie() {
        return this.idLocatie;
    }

    public String getTara() {
        return this.tara;
    }

    public String getOras() {
        return this.oras;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public void setIdLocatie(int idLocatie) {
        this.idLocatie = idLocatie;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public static class LocatieDtoBuilder {
        private int idLocatie;
        private String tara;
        private String oras;
        private String adresa;

        LocatieDtoBuilder() {
        }

        public LocatieDtoBuilder idLocatie(int idLocatie) {
            this.idLocatie = idLocatie;
            return this;
        }

        public LocatieDtoBuilder tara(String tara) {
            this.tara = tara;
            return this;
        }

        public LocatieDtoBuilder oras(String oras) {
            this.oras = oras;
            return this;
        }

        public LocatieDtoBuilder adresa(String adresa) {
            this.adresa = adresa;
            return this;
        }

        public LocatieDto build() {
            return new LocatieDto(idLocatie, tara, oras, adresa);
        }

        public String toString() {
            return "LocatieDto.LocatieDtoBuilder(idLocatie=" + this.idLocatie + ", tara=" + this.tara + ", oras=" + this.oras + ", adresa=" + this.adresa + ")";
        }
    }
}
