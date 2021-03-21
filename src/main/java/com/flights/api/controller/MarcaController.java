package com.flights.api.controller;

import com.flights.api.dto.MarcaDto;
import com.flights.api.service.MarcaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/plane-brands")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaDto>> getAllPlaneBrands() {

        return ResponseEntity.ok(marcaService.getAllPlaneBrands());
    }
}
