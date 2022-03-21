package com.mercadolibre.challenge.infraestructure.database.datasources;

import com.mercadolibre.challenge.infraestructure.database.entities.DnaEntity;
import com.mercadolibre.challenge.infraestructure.database.repositories.DnaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


class DnaDataSourcesTest {

    @InjectMocks
    DnaDataSources dnaDataSources;

    @Mock
    DnaDao dao;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAdn() {
        DnaEntity dna = Mockito.mock(DnaEntity.class);
        Mockito.when(dao.save(dna)).thenReturn(dna);
        dnaDataSources.addAdn("");
        Mockito.verify(dao).save(Mockito.any(DnaEntity.class));
    }

    @Test
    void allDna() {
        List<DnaEntity> list = new ArrayList<>();
        Mockito.when(dao.findAll()).thenReturn(list);
        dnaDataSources.allDna();
        Mockito.verify(dao).findAll();
    }
}