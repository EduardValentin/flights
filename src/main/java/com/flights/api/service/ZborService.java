package com.flights.api.service;

import com.flights.api.dto.ZborDto;
import com.flights.api.dto.ZborViewDto;
import com.flights.api.mappings.DTOMapper;
import com.flights.api.model.Avion;
import com.flights.api.model.Pilot;
import com.flights.api.model.ProgramZbor;
import com.flights.api.model.Ruta;
import com.flights.api.model.RuteZbor;
import com.flights.api.model.StatusZbor;
import com.flights.api.model.Zbor;
import com.flights.api.repository.PilotRepository;
import com.flights.api.repository.ProgramZborRepository;
import com.flights.api.repository.RutaRepository;
import com.flights.api.repository.RutaZborRepository;
import com.flights.api.repository.StatusZborRepository;
import com.flights.api.repository.ZborRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ZborService {

    public static final String ACCEPTAT = "ACCEPTAT";
    private final ZborRepository repository;
    private final DTOMapper dtoMapper;
    private final StatusZborRepository statusZborRepository;
    private final RutaRepository rutaRepository;
    private final RutaZborRepository rutaZborRepository;
    private final ProgramZborRepository programZborRepository;
    private final PilotRepository pilotRepository;

    public ZborService(ZborRepository repository, DTOMapper dtoMapper, StatusZborRepository statusZborRepository,
                       RutaRepository rutaRepository, RutaZborRepository rutaZborRepository, ProgramZborRepository programZborRepository, PilotRepository pilotRepository) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
        this.statusZborRepository = statusZborRepository;
        this.rutaRepository = rutaRepository;
        this.rutaZborRepository = rutaZborRepository;
        this.programZborRepository = programZborRepository;
        this.pilotRepository = pilotRepository;
    }

    public List<ZborViewDto> findAll() {

        return dtoMapper.mapList(repository.findAll(), dtoMapper::toZborViewDto);
    }

    public ZborViewDto createZbor(ZborDto zborDto, Avion avion) {

        StatusZbor statusZbor = statusZborRepository.findByStatus(ACCEPTAT)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST));

        ProgramZbor programZbor = ProgramZbor.builder()
                .timpPlecare(zborDto.getDataPlecare())
                .timpSosire(zborDto.getDataSosire())
                .build();

        programZbor = programZborRepository.save(programZbor);

        Ruta ruta = rutaRepository.findById(zborDto.getIdRuta())
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST));

        Pilot pilot = pilotRepository.findById(zborDto.getIdPilot())
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST));

        Zbor zbor = Zbor.builder()
                .programZbor(programZbor)
                .statusZbor(statusZbor)
                .avion(avion)
                .pilot(pilot)
                .build();

        zbor = repository.save(zbor);


        RuteZbor ruteZbor = new RuteZbor();
        ruteZbor.setRuta(ruta);
        ruteZbor.setZbor(zbor);

        zbor.setRute(Set.of(ruteZbor));

        rutaZborRepository.save(ruteZbor);

        return dtoMapper.toZborViewDto(zbor);
    }
}
