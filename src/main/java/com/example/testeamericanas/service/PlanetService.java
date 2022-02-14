package com.example.testeamericanas.service;

import com.example.testeamericanas.domain.dto.PlanetInputDTO;
import com.example.testeamericanas.domain.dto.StarWarsApiResponseDTO;
import com.example.testeamericanas.domain.model.Planet;
import com.example.testeamericanas.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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

    @Transactional
    public void createPlanet(PlanetInputDTO planetInputDTO) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String planetName = planetInputDTO.getName();

        planetName = planetName.substring(0,1).toUpperCase() + planetName.substring(1).toLowerCase();

        Planet existentPlanet = planetRepository.findPlanetByName(planetName);

        if (!Objects.isNull(existentPlanet)) {
            throw new Exception("Planeta ja existe no banco");
        }

        ResponseEntity<StarWarsApiResponseDTO> response = restTemplate.exchange(
                "https://swapi.dev/api/planets/?search="+planetName,
                HttpMethod.GET,
                null, StarWarsApiResponseDTO.class);

        StarWarsApiResponseDTO starWarsApiResponseDTO = response.getBody();

        int currentMovieAppearances = 0;

        if(!(starWarsApiResponseDTO == null || starWarsApiResponseDTO.getResults().isEmpty())) {
            if (starWarsApiResponseDTO.getResults().get(0).getFilms().size() > 0) {
                currentMovieAppearances = starWarsApiResponseDTO.getResults().get(0).getFilms().size();
            }
        }

        Planet newPlanet = new Planet();
        newPlanet.setWeather(planetInputDTO.getWeather());
        newPlanet.setName(planetName);
        newPlanet.setTerrain(planetInputDTO.getTerrain());
        newPlanet.setMovieAppearances(currentMovieAppearances);
        planetRepository.save(newPlanet);
    }
}
