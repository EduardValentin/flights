package com.flights.api.controller;

import com.flights.api.dto.AvionViewDto;
import com.flights.api.dto.CreateAvionDto;
import com.flights.api.service.AvionService;
import com.flights.api.service.MarcaAvionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/airplanes")
public class AvionController {

    private final AvionService avionService;
    private final MarcaAvionService marcaAvionService;

    public AvionController(AvionService avionService, MarcaAvionService marcaAvionService) {
        this.avionService = avionService;
        this.marcaAvionService = marcaAvionService;
    }

    @GetMapping
    public ResponseEntity<List<AvionViewDto>> getAirplanes() {
        return ResponseEntity.ok(avionService.getAllAirplanes());
    }

    @PostMapping
    public ResponseEntity<AvionViewDto> addAirplane(@Valid @RequestBody CreateAvionDto avionDTO) {

        return marcaAvionService.findById(avionDTO.getMarca().getId())
                .map(marca -> ResponseEntity.ok(avionService.addAirplane(avionDTO, marca)))
                .orElse(ResponseEntity.badRequest().build());
    }
}
