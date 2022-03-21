package com.mercadolibre.challenge.application.usescases;

import com.mercadolibre.challenge.domain.events.HumanContract;
import com.mercadolibre.challenge.domain.services.DnaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class StatsDnaTest {

    @InjectMocks
    StatsDna statsDna;

    @Mock
    DnaService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateStat(){
        HumanContract.OnResponseStats responseStats = (humans, mutants, ratio) -> {};
        service.count(responseStats);
        statsDna.execute();
        Assertions.assertEquals(statsDna.getCountHuman(),0);
        Assertions.assertEquals(statsDna.getCountMutant(),0);
        Assertions.assertEquals(statsDna.getRatio(),0.0);
    }

}