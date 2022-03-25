package com.mercadolibre.challenge.infraestructure.rest.dto;

import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDna{
    private String[] dna;
}
