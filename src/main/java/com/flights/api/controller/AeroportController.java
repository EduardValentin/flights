package com.flights.api.controller;

import com.flights.api.dto.AeroportDto;
import com.flights.api.dto.AeroportViewDto;
import com.flights.api.service.AeroportService;
import com.flights.api.service.LocatieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/airports")
public class AeroportController {

    private final AeroportService service;
    private final LocatieService locatieService;

    public AeroportController(AeroportService service, LocatieService locatieService) {
        this.service = service;
        this.locatieService = locatieService;
    }

    @GetMapping
    public ResponseEntity<List<AeroportViewDto>> getAll() {

        return ResponseEntity.ok(service.getAirportsListDto());
    }

    @PostMapping
    public ResponseEntity<AeroportViewDto> create(@RequestBody @Valid AeroportDto aeroportDto) {

        return locatieService.getLocatie(aeroportDto.getIdLocatie())
                .map(locatie -> ResponseEntity.ok(service.createAerport(aeroportDto, locatie)))
                .orElse(ResponseEntity.notFound().build());
    }
}
