package com.flights.api.controller;

import com.flights.api.dto.ZborDto;
import com.flights.api.dto.ZborViewDto;
import com.flights.api.service.AvionService;
import com.flights.api.service.ZborService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/flights")
public class ZborController {

    private final ZborService zborService;
    private final AvionService avionService;

    public ZborController(ZborService zborService, AvionService avionService) {
        this.zborService = zborService;
        this.avionService = avionService;
    }

    @GetMapping
    public ResponseEntity<List<ZborViewDto>> getAll() {

        return ResponseEntity.ok(zborService.findAll());
    }

    @PostMapping
    public ResponseEntity<ZborViewDto> create(@RequestBody @Valid ZborDto zborDto) {

        return avionService.getAirplane(zborDto.getIdAvion())
                .map(avion -> ResponseEntity.ok(zborService.createZbor(zborDto, avion)))
                .orElse(ResponseEntity.badRequest().build());

    }
}
