package com.mercadolibre.challenge.infraestructure.rest.dto;

public class ValidateDnaDto {

    private final boolean isMutant;


    public ValidateDnaDto(boolean isMutant) {
        this.isMutant = isMutant;
    }

    public boolean isMutant() {
        return isMutant;
    }
}
