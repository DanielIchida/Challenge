package com.mercadolibre.challenge.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatDto {

    private int countMutantDna;
    private int countHumanDna;
    private double ratio;

}
