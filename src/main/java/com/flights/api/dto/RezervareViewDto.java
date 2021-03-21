package com.flights.api.dto;

import com.flights.api.model.Loc;


public class RezervareViewDto {

    private final int idRezervare;
    private final ZborViewDto zbor;
    private final ClientViewDto client;
    private final AvionViewDto avion;
    private final Loc loc;
    private final double pret;
    private final double discount;
    private final String status;

    RezervareViewDto(int idRezervare, ZborViewDto zbor, ClientViewDto client, AvionViewDto avion, Loc loc, double pret, double discount, String status) {
        this.idRezervare = idRezervare;
        this.zbor = zbor;
        this.client = client;
        this.avion = avion;
        this.loc = loc;
        this.pret = pret;
        this.discount = discount;
        this.status = status;
    }

    public static RezervareViewDtoBuilder builder() {
        return new RezervareViewDtoBuilder();
    }

    public int getIdRezervare() {
        return this.idRezervare;
    }

    public ZborViewDto getZbor() {
        return this.zbor;
    }

    public ClientViewDto getClient() {
        return this.client;
    }

    public AvionViewDto getAvion() {
        return this.avion;
    }

    public Loc getLoc() {
        return this.loc;
    }

    public double getPret() {
        return this.pret;
    }

    public double getDiscount() {
        return this.discount;
    }

    public String getStatus() {
        return this.status;
    }

    public static class RezervareViewDtoBuilder {
        private int idRezervare;
        private ZborViewDto zbor;
        private ClientViewDto client;
        private AvionViewDto avion;
        private Loc loc;
        private double pret;
        private double discount;
        private String status;

        RezervareViewDtoBuilder() {
        }

        public RezervareViewDtoBuilder idRezervare(int idRezervare) {
            this.idRezervare = idRezervare;
            return this;
        }

        public RezervareViewDtoBuilder zbor(ZborViewDto zbor) {
            this.zbor = zbor;
            return this;
        }

        public RezervareViewDtoBuilder client(ClientViewDto client) {
            this.client = client;
            return this;
        }

        public RezervareViewDtoBuilder avion(AvionViewDto avion) {
            this.avion = avion;
            return this;
        }

        public RezervareViewDtoBuilder loc(Loc loc) {
            this.loc = loc;
            return this;
        }

        public RezervareViewDtoBuilder pret(double pret) {
            this.pret = pret;
            return this;
        }

        public RezervareViewDtoBuilder discount(double discount) {
            this.discount = discount;
            return this;
        }

        public RezervareViewDtoBuilder status(String status) {
            this.status = status;
            return this;
        }

        public RezervareViewDto build() {
            return new RezervareViewDto(idRezervare, zbor, client, avion, loc, pret, discount, status);
        }

        public String toString() {
            return "RezervareViewDto.RezervareViewDtoBuilder(idRezervare=" + this.idRezervare + ", zbor=" + this.zbor + ", client=" + this.client + ", avion=" + this.avion + ", loc=" + this.loc + ", pret=" + this.pret + ", discount=" + this.discount + ", status=" + this.status + ")";
        }
    }
}
