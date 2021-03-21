package com.flights.api.service;

import com.flights.api.model.MarcaAvion;
import com.flights.api.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarcaAvionService {

    private final MarcaRepository marcaRepository;

    public MarcaAvionService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }


    public Optional<MarcaAvion> findById(int id) {
        return marcaRepository.findById(id);
    }
}
