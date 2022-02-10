package com.example.testeamericanas.domain.converter;

import com.example.testeamericanas.domain.dto.PlanetDTO;
import com.example.testeamericanas.domain.model.Planet;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PlanetConverter {

    @Named("toPlanedDto")
    PlanetDTO toPlanetDto(Planet planet);

    @Named("toPlanedDtoList")
    @IterableMapping(qualifiedByName = "toPlanetDto")
    List<PlanetDTO> toPlanetDto(List<Planet> planets);
}
