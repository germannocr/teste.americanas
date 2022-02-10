package com.example.testeamericanas.service;

import com.example.testeamericanas.domain.model.Planet;
import com.example.testeamericanas.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Transactional(readOnly = true)
    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Planet findById(long planetId) {
        return planetRepository.findPlanetById(planetId);
    }

    @Transactional(readOnly = true)
    public Planet getPlanetByName(String planetName) {
        String planetFirstLetter = planetName.substring(0, 1).toUpperCase();
        String planetRemainingLetters = planetName.substring(2).toLowerCase();
        planetName = planetFirstLetter + planetRemainingLetters;
        return planetRepository.findPlanetByName(planetName);
    }

    @Transactional
    public void deletePlanet(long planetId) throws Exception {
        Planet planet = planetRepository.findPlanetById(planetId);
        if(Objects.isNull(planet)) {
            throw new Exception("Planeta não existe, e não pode ser deletado");
        }

        planetRepository.delete(planet);
    }
}
