package com.flights.api.service;

import com.flights.api.dto.PilotViewDto;
import com.flights.api.mappings.DTOMapper;
import com.flights.api.model.Pilot;
import com.flights.api.repository.PilotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotService {

    private final PilotRepository repository;
    private final DTOMapper dtoMapper;

    public PilotService(PilotRepository repository, DTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    public Optional<Pilot> getPilot(int id) {

        return repository.findById(id);
    }

    public List<PilotViewDto> getAll() {

        return dtoMapper.mapList(repository.findAll(), dtoMapper::toPilotViewDto);
    }
}
