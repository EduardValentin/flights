package com.flights.api.repository;

import com.flights.api.model.ProgramZbor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramZborRepository extends JpaRepository<ProgramZbor, Integer> {
}
