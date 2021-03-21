package com.flights.api.repository;

import com.flights.api.model.Avion;
import com.flights.api.model.Loc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocRepository extends JpaRepository<Loc, Integer> {

    List<Loc> findAllByAvion(Avion avion);
}
