package com.example.testeamericanas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetDTO {

    private int id;
    private String name;
    private String weather;
    private String terrain;
    private int movieAppearances;
}
