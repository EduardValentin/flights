package com.flights.api.repository;

import com.flights.api.model.StatusZbor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusZborRepository extends JpaRepository<StatusZbor, Integer> {

    Optional<StatusZbor> findByStatus(String status);
}
