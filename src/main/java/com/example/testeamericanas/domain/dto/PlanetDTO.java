package com.example.testeamericanas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetDTO {

    @NotNull
    private int id;

    @NotNull
    private String nome;

    @NotNull
    private String clima;

    @NotNull
    private String terreno;

    @NotNull
    private int movieAppearances;
}
