package com.flights.api.controller;

import com.flights.api.dto.RezervareDto;
import com.flights.api.dto.RezervareViewDto;
import com.flights.api.service.RezervareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/reservations")
public class RezervareController {

    private final RezervareService rezervareService;

    public RezervareController(RezervareService rezervareService) {
        this.rezervareService = rezervareService;
    }

    @GetMapping
    public ResponseEntity<List<RezervareViewDto>> getAll() {

        return ResponseEntity.ok(rezervareService.findAll());
    }

    @PostMapping
    public ResponseEntity<RezervareViewDto> create(@RequestBody @Valid RezervareDto rezervareDto) {

        return ResponseEntity.ok(rezervareService.create(rezervareDto));
    }
}
