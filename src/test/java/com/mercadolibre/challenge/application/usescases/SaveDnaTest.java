package com.mercadolibre.challenge.application.usescases;

import com.mercadolibre.challenge.domain.events.HumanContract;
import com.mercadolibre.challenge.domain.exceptions.InvalidStructureDnaException;
import com.mercadolibre.challenge.domain.services.DnaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SaveDnaTest {

    @InjectMocks
    SaveDna saveDna;

    @Mock
    DnaService service;

    String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateSave() throws InvalidStructureDnaException {
        HumanContract.OnResponseHumanValidate onResponseHumanValidate = isMutant -> {};
        service.saveDna(dna,onResponseHumanValidate);
        saveDna.execute(dna);
        boolean validate = saveDna.isValidateAdn();
        Assertions.assertEquals(validate,false);
    }

}