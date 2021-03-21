package com.flights.api.service;

import com.flights.api.dto.LocatieDto;
import com.flights.api.mappings.DTOMapper;
import com.flights.api.model.Locatie;
import com.flights.api.repository.LocatieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocatieService {

    private final LocatieRepository repository;
    private final DTOMapper dtoMapper;

    public LocatieService(LocatieRepository repository, DTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    public Optional<Locatie> getLocatie(int locatieId) {

        return repository.findById(locatieId);
    }

    public List<LocatieDto> getLocations() {

        return dtoMapper.mapList(repository.findAll(), dtoMapper::toLocatieDto);
    }
}
