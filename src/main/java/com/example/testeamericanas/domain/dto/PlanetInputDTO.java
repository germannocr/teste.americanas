package com.example.testeamericanas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetInputDTO {
    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("weather")
    private String weather;

    @NotNull
    @JsonProperty("terrain")
    private String terrain;

    @NotNull
    @JsonProperty("movieAppearances")
    private int movieAppearances;
}
