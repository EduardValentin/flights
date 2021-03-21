package com.flights.api.repository;

import com.flights.api.model.Clasa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasaRepository extends JpaRepository<Clasa, Integer> {
    Optional<Clasa> findByDenumire(String denumire);
}
