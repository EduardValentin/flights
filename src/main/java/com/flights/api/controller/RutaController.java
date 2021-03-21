package com.flights.api.controller;

import com.flights.api.dto.RutaDto;
import com.flights.api.dto.RutaViewDto;
import com.flights.api.service.AeroportService;
import com.flights.api.service.RutaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/routes")
public class RutaController {

    private final RutaService service;
    private final AeroportService aeroportService;

    public RutaController(RutaService service, AeroportService aeroportService) {
        this.service = service;
        this.aeroportService = aeroportService;
    }

    @GetMapping
    public ResponseEntity<List<RutaViewDto>> getRoutes() {

        return ResponseEntity.ok(service.getAllRoutes());
    }

    @PostMapping
    public ResponseEntity<RutaViewDto> createRoute(@RequestBody @Valid RutaDto rutaDto) {

        return aeroportService.getAeroport(rutaDto.getIdAeroportPlecare())
                .map(aeroportPlecare -> aeroportService.getAeroport(rutaDto.getIdAeroportSosire())
                        .map(aeroportSosire -> ResponseEntity.ok(service.createRoute(aeroportPlecare, aeroportSosire)))
                        .orElse(ResponseEntity.badRequest().build()))
                .orElse(ResponseEntity.badRequest().build());
    }
}
