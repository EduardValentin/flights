package com.flights.api.repository;

import com.flights.api.model.RuteZbor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaZborRepository extends JpaRepository<RuteZbor, Integer> {
}
