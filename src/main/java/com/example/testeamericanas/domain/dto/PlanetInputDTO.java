package com.example.testeamericanas.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetInputDTO {
    @NotNull(message = "O campo name não pode ser nulo.")
    @NotBlank (message = "O campo name não pode ser vazio.")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "O campo weather não pode ser nulo.")
    @NotBlank (message = "O campo weather não pode ser vazio.")
    @JsonProperty("weather")
    private String weather;

    @NotNull(message = "O campo terrain não pode ser nulo.")
    @NotBlank (message = "O campo terrain não pode ser vazio.")
    @JsonProperty("terrain")
    private String terrain;
}
