package com.mercadolibre.challenge.infraestructure.database.datasources;


import com.mercadolibre.challenge.application.repositories.DnaRepository;
import com.mercadolibre.challenge.infraestructure.database.entities.DnaEntity;
import com.mercadolibre.challenge.infraestructure.database.repositories.DnaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DnaDataSources implements DnaRepository {

    @Autowired
    private DnaDao dnaDao;

    @Override
    public void addAdn(String chains) {
         DnaEntity dna = new DnaEntity();
         dna.setChains(chains);
         dnaDao.save(dna);
    }

    @Override
    public List<String> allDna() {
        return dnaDao.findAll()
                .stream()
                .map(DnaEntity::getChains)
                .collect(Collectors.toList());
    }
}


