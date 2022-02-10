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
    @JsonProperty("nome")
    private String nome;

    @NotNull
    @JsonProperty("clima")
    private String clima;

    @NotNull
    @JsonProperty("terreno")
    private String terreno;

    @NotNull
    @JsonProperty("movieAppearances")
    private int movieAppearances;
}
