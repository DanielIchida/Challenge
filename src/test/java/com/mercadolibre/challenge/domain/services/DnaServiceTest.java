package com.mercadolibre.challenge.domain.services;

import com.google.gson.Gson;
import com.mercadolibre.challenge.application.repositories.DnaRepository;
import com.mercadolibre.challenge.domain.events.HumanContract;
import com.mercadolibre.challenge.domain.exceptions.InvalidStructureDnaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DnaServiceTest {

    @InjectMocks
    DnaService service;

    @Mock
    DnaRepository repository;

    @Mock
    HumanContract.OnResponseStats onResponseStats;

    @Mock
    HumanContract.OnResponseHumanValidate onResponseHumanValidate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveDna() throws InvalidStructureDnaException {
        String[] chains = {
            "ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"
        };
        String dna = new Gson().toJson(chains);
        Mockito.doNothing().when(repository).addAdn(dna);
        onResponseHumanValidate.onCallback(true);
        service.saveDna(chains,onResponseHumanValidate);
        Mockito.verify(repository).addAdn(dna);
    }

    @Test
    void count() {
        List<String> list = new ArrayList<>();
        Mockito.when(repository.allDna()).thenReturn(list);
        onResponseStats.onCallback(0,0,0.0);
        service.count(onResponseStats);
        Mockito.verify(repository).allDna();
    }
}