package com.example.testeamericanas.controller;

import com.example.testeamericanas.domain.converter.PlanetConverter;
import com.example.testeamericanas.domain.dto.PlanetDTO;
import com.example.testeamericanas.domain.dto.PlanetInputDTO;
import com.example.testeamericanas.domain.model.Planet;
import com.example.testeamericanas.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/planet")
@Validated
public class PlanetController {

    @Autowired
    private final PlanetService planetService;

    @Autowired
    private final PlanetConverter planetConverter;

    public PlanetController(PlanetService planetService, PlanetConverter planetConverter) {
        this.planetService = planetService;
        this.planetConverter = planetConverter;
    }

    @GetMapping(value = "/all")
    public List<PlanetDTO> getAllPlanets() throws Exception {
        List<Planet> planets = planetService.getAllPlanets();
        List<PlanetDTO> planetDtos = planetConverter.toPlanetDto(planets);
        if (planetDtos == null || planetDtos.size() <= 0) {
            throw new Exception("Erro na listagem");
        }
        return planetDtos;
    }

    @GetMapping(value = "/search/{planetId}")
    public PlanetDTO getPlanet(@PathVariable("planetId") long planetId) throws Exception {
        Planet planet = planetService.findById(planetId);
        PlanetDTO planetDto = planetConverter.toPlanetDto(planet);
        if (planetDto == null) {
            throw new Exception("Erro na listagem por id");
        }
        return planetDto;
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlanet(@RequestBody PlanetInputDTO planetInputDTO) {
        planetService.createPlanet(planetInputDTO);
    }

    @PostMapping(value = "/{planetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlanet(@PathVariable long planetId) throws Exception {
        planetService.deletePlanet(planetId);
    }

}
