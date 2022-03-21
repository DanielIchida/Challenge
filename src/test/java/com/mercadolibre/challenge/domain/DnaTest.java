package com.mercadolibre.challenge.domain;

import com.mercadolibre.challenge.domain.exceptions.InvalidStructureDnaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DnaTest {

    String[] chain;
    Dna dna;

    @BeforeEach
    void setUp() {
      chain  = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
      dna = new Dna(chain);
    }

    @Test
    void testExistLetter() throws InvalidStructureDnaException {
        dna.isExitsLetter();
    }

    @Test
    void testValidateStructure() throws InvalidStructureDnaException {
        dna.isStructure();
    }

    @Test
    void testIsMutant() {
        Assertions.assertTrue(dna.isMutant());
    }
}