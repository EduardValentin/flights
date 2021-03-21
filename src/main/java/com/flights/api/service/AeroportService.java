package com.flights.api.service;

import com.flights.api.dto.AeroportDto;
import com.flights.api.dto.AeroportViewDto;
import com.flights.api.mappings.DTOMapper;
import com.flights.api.mappings.EntityMapper;
import com.flights.api.model.Aeroport;
import com.flights.api.model.Locatie;
import com.flights.api.repository.AeroportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeroportService {

    private final AeroportRepository repository;
    private final DTOMapper dtoMapper;
    private final EntityMapper entityMapper;

    public AeroportService(AeroportRepository repository, DTOMapper dtoMapper, EntityMapper entityMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }

    public List<AeroportViewDto> getAirportsListDto() {

        return dtoMapper.toAeroportViewDtoList(repository.findAll());
    }

    public AeroportViewDto createAerport(AeroportDto aeroportDto, Locatie locatie) {

        Aeroport aeroport = entityMapper.toAeroport(aeroportDto, locatie);
        Aeroport saved = repository.save(aeroport);
        return dtoMapper.toAeroportViewDto(saved);
    }

    public Optional<Aeroport> getAeroport(int id) {

        return repository.findById(id);
    }
}
