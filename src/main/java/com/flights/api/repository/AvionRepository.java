package com.flights.api.repository;

import com.flights.api.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository  extends JpaRepository<Avion, Integer> {
}
