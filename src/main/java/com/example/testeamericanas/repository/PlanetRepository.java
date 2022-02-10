package com.example.testeamericanas.repository;

import com.example.testeamericanas.domain.model.Planet;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Planet findPlanetByName(String planetName);

    Planet findPlanetById(long planetId);

    @NotNull List<Planet> findAll();
}