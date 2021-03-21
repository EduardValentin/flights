package com.flights.api.mappings;

import com.flights.api.dto.AeroportViewDto;
import com.flights.api.dto.AvionViewDto;
import com.flights.api.dto.ClientViewDto;
import com.flights.api.dto.LocViewDto;
import com.flights.api.dto.LocatieDto;
import com.flights.api.dto.MarcaDto;
import com.flights.api.dto.PilotViewDto;
import com.flights.api.dto.RezervareViewDto;
import com.flights.api.dto.RutaViewDto;
import com.flights.api.dto.ZborViewDto;
import com.flights.api.model.Aeroport;
import com.flights.api.model.Avion;
import com.flights.api.model.Client;
import com.flights.api.model.Loc;
import com.flights.api.model.Locatie;
import com.flights.api.model.MarcaAvion;
import com.flights.api.model.Pilot;
import com.flights.api.model.Rezervare;
import com.flights.api.model.Ruta;
import com.flights.api.model.RuteZbor;
import com.flights.api.model.Zbor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Component
public class DTOMapper {

    public AvionViewDto toAvionDTO(Avion avion) {

        MarcaDto marcaDTO = toMarcaDTO(avion.getMarcaAvion());
        return AvionViewDto.builder()
                .id(avion.getIdAvion())
                .greutateTone(avion.getGreutateTone())
                .locuriMaxime(avion.getLocuriMaxime())
                .marca(marcaDTO)
                .build();
    }

    public MarcaDto toMarcaDTO(MarcaAvion marcaAvion) {

        return MarcaDto.builder()
                .id(marcaAvion.getIdMarcaAvion())
                .nume(marcaAvion.getNume())
                .build();
    }

    public LocatieDto toLocatieDto(Locatie locatie) {

        return LocatieDto.builder()
                .idLocatie(locatie.getIdLocatie())
                .tara(locatie.getTara())
                .oras(locatie.getOras())
                .adresa(locatie.getAdresa())
                .build();
    }

    public AeroportViewDto toAeroportViewDto(Aeroport aeroport) {

        return AeroportViewDto.builder()
                .idAeroport(aeroport.getIdAeroport())
                .denumire(aeroport.getDenumire())
                .locatie(toLocatieDto(aeroport.getLocatie()))
                .build();
    }

    public List<AeroportViewDto> toAeroportViewDtoList(List<Aeroport> aeroportList) {

        return aeroportList.stream()
                .map(this::toAeroportViewDto)
                .collect(toList());
    }

    public RutaViewDto toRutaViewDto(Ruta ruta) {

        return RutaViewDto.builder()
                .idRuta(ruta.getIdRuta())
                .aeroportPlecare(toAeroportViewDto(ruta.getAeroportPlecare()))
                .aeroportDestinatie(toAeroportViewDto(ruta.getAeroportDestinatie()))
                .build();
    }

    public PilotViewDto toPilotViewDto(Pilot pilot) {

        return PilotViewDto.builder()
                .idPilot(pilot.getIdPilot())
                .actIdentitate(pilot.getActIdentitate())
                .cnp(pilot.getCnp())
                .dataLicenta(pilot.getDataLicenta())
                .licentaZbor(pilot.getLicentaZbor())
                .nrOreZbor(pilot.getNrOreZbor())
                .nume(pilot.getNume())
                .prenume(pilot.getPrenume())
                .build();
    }

    public ZborViewDto toZborViewDto(Zbor zbor) {

        Set<RutaViewDto> rute = zbor.getRute().stream()
                .map(RuteZbor::getRuta)
                .map(this::toRutaViewDto)
                .collect(toSet());

        return ZborViewDto.builder()
                .dataPlecare(zbor.getProgramZbor().getTimpPlecare())
                .dataSosire(zbor.getProgramZbor().getTimpSosire())
                .idZbor(zbor.getIdZbor())
                .pilot(toPilotViewDto(zbor.getPilot()))
                .avion(toAvionDTO(zbor.getAvion()))
                .rute(rute)
                .build();
    }

    public ClientViewDto toClientViewDto(Client client) {

        return ClientViewDto.builder()
                .idClient(client.getIdClient())
                .actIdentitate(client.getActIdentitate())
                .cnp(client.getCnp())
                .email(client.getEmail())
                .nume(client.getNume())
                .prenume(client.getPrenume())
                .telefon(client.getTelefon())
                .build();
    }

    public RezervareViewDto toRezervareViewDto(Rezervare rezervare) {

        return RezervareViewDto.builder()
                .avion(toAvionDTO(rezervare.getAvion()))
                .client(toClientViewDto(rezervare.getClient()))
                .discount(rezervare.getDiscount())
                .idRezervare(rezervare.getIdRezervare())
                .loc(rezervare.getLoc())
                .pret(rezervare.getPret())
                .status(rezervare.getStatus())
                .zbor(toZborViewDto(rezervare.getZbor()))
                .build();
    }

    public LocViewDto toLocViewDto(Loc loc) {

        return LocViewDto.builder()
                .idLoc(loc.getIdLoc())
                .nrLoc(loc.getNrLoc())
                .build();
    }

    public <S, D> List<D> mapList(List<S> list, Function<S, D> mapper) {

        return list.stream()
                .map(mapper)
                .collect(toList());
    }
}
