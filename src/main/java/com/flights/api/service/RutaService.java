package com.flights.api.service;

import com.flights.api.dto.RutaViewDto;
import com.flights.api.mappings.DTOMapper;
import com.flights.api.model.Aeroport;
import com.flights.api.model.Ruta;
import com.flights.api.repository.RutaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    private final RutaRepository repository;
    private final DTOMapper dtoMapper;

    public RutaService(RutaRepository repository, DTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    public List<RutaViewDto> getAllRoutes() {

        List<Ruta> routes = repository.findAll();
        return dtoMapper.mapList(routes, dtoMapper::toRutaViewDto);
    }

    public RutaViewDto createRoute(Aeroport plecare, Aeroport destinatie) {

        Ruta ruta = Ruta.builder()
                .aeroportPlecare(plecare)
                .aeroportDestinatie(destinatie)
                .build();

        Ruta saved = repository.save(ruta);
        return dtoMapper.toRutaViewDto(saved);
    }
}
