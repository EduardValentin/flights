package com.flights.api.repository;

import com.flights.api.model.Zbor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZborRepository extends JpaRepository<Zbor, Integer> {
}
