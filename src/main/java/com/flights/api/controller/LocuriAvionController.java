package com.flights.api.controller;

import com.flights.api.dto.LocViewDto;
import com.flights.api.service.AvionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/airplanes/{airplaneId}/seats")
public class LocuriAvionController {

    private final AvionService avionService;

    public LocuriAvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @GetMapping
    public ResponseEntity<List<LocViewDto>> getAll(@PathVariable("airplaneId") int airplaneId) {

        return avionService.getAirplane(airplaneId)
                .map(avionService::getSeats)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
