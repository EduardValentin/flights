package com.flights.api.mappings;

import com.flights.api.dto.AeroportDto;
import com.flights.api.dto.AvionViewDto;
import com.flights.api.dto.CreateAvionDto;
import com.flights.api.model.Aeroport;
import com.flights.api.model.Avion;
import com.flights.api.model.Locatie;
import com.flights.api.model.MarcaAvion;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public Avion toAvion(AvionViewDto avionViewDTO, MarcaAvion marcaAvion) {

        return Avion.builder()
                .greutateTone(avionViewDTO.getGreutateTone())
                .marcaAvion(marcaAvion)
                .locuriMaxime(avionViewDTO.getLocuriMaxime())
                .build();
    }

    public Avion toAvion(CreateAvionDto avionDTO, MarcaAvion marcaAvion) {

        return Avion.builder()
                .greutateTone(avionDTO.getGreutateTone())
                .marcaAvion(marcaAvion)
                .locuriMaxime(avionDTO.getLocuriMaxime())
                .build();
    }

    public Aeroport toAeroport(AeroportDto aeroportDto, Locatie locatie) {

        return Aeroport.builder()
                .denumire(aeroportDto.getDenumire())
                .locatie(locatie)
                .build();
    }
}
