package com.flights.api.controller;

import com.flights.api.dto.LocatieDto;
import com.flights.api.service.LocatieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/locations")
public class LocatieController {

    private final LocatieService locatieService;

    public LocatieController(LocatieService locatieService) {
        this.locatieService = locatieService;
    }

    @GetMapping
    public ResponseEntity<List<LocatieDto>> getLocations() {

        return ResponseEntity.ok(locatieService.getLocations());
    }
}
