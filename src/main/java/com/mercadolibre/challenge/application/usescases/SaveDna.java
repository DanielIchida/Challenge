package com.mercadolibre.challenge.application.usescases;

import com.mercadolibre.challenge.domain.exceptions.InvalidStructureDnaException;
import com.mercadolibre.challenge.domain.services.DnaService;

public class SaveDna {

    private final DnaService dnaService;
    private boolean validateAdn;

    public SaveDna(DnaService dnaService) {
        this.dnaService = dnaService;
        this.validateAdn = false;
    }

    public boolean execute(String[] dna) throws InvalidStructureDnaException {
        this.dnaService.saveDna(dna, isMutant -> {
            this.validateAdn = isMutant;
        });
        return this.validateAdn;
    }

    public boolean isValidateAdn() {
        return validateAdn;
    }
}
