package com.flights.api.service;

import com.flights.api.dto.MarcaDto;
import com.flights.api.mappings.DTOMapper;
import com.flights.api.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;
    private final DTOMapper dtoMapper;

    public MarcaService(MarcaRepository marcaRepository, DTOMapper dtoMapper) {
        this.marcaRepository = marcaRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<MarcaDto> getAllPlaneBrands() {

        return marcaRepository.findAll().stream()
                .map(dtoMapper::toMarcaDTO)
                .collect(Collectors.toList());
    }
}
