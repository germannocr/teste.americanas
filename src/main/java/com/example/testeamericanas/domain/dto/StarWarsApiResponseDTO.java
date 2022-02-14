package com.example.testeamericanas.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class StarWarsApiResponseDTO {
    private int count;
    private List<PlanetApiInfoDTO> results;
    private String next;
    private String previous;
}
