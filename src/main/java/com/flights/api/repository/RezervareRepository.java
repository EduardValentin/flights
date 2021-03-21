package com.flights.api.repository;

import com.flights.api.model.Rezervare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervareRepository extends JpaRepository<Rezervare, Integer> {
}
