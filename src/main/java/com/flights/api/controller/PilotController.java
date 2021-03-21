package com.flights.api.controller;

import com.flights.api.dto.PilotViewDto;
import com.flights.api.service.PilotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/pilots")
public class PilotController {

    private final PilotService pilotService;

    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @GetMapping
    public ResponseEntity<List<PilotViewDto>> getAll() {

        return ResponseEntity.ok(pilotService.getAll());
    }
}
