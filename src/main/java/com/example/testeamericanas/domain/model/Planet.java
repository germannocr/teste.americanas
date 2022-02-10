package com.example.testeamericanas.domain.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Planet {


    private int id;

    @NotNull
    private String name;

    @NotNull
    private String weather;

    @NotNull
    private String terrain;

    @NotNull
    private int movieAppearances;
}
