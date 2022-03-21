package com.mercadolibre.challenge.domain.services;

import com.google.gson.Gson;
import com.mercadolibre.challenge.application.repositories.DnaRepository;
import com.mercadolibre.challenge.domain.Dna;
import com.mercadolibre.challenge.domain.events.HumanContract;
import com.mercadolibre.challenge.domain.exceptions.InvalidStructureDnaException;

import java.util.List;

public class DnaService {

    private final DnaRepository dnaRepository;

    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public void saveDna(String[] chains, HumanContract.OnResponseHumanValidate response) throws InvalidStructureDnaException {
        Dna adn = new Dna(chains);
        adn.isStructure();
        adn.isExitsLetter();
        dnaRepository.addAdn(new Gson().toJson(adn.getChains()));
        boolean isMutant = validateIsMutant(adn);
        response.onCallback(isMutant);
    }

    public void count(HumanContract.OnResponseStats response){
        List<String> listDna = dnaRepository.allDna();
        float human = 0;
        float mutant = 0;
        float ratio = 0;
        for (String dna : listDna) {
             String[] chains = new Gson().fromJson(dna,String[].class);
             Dna adn = new Dna(chains);
             boolean isMutant = validateIsMutant(adn);
             if(isMutant){
                mutant = mutant + 1;
             }else{
                human = human + 1;
             }
        }
        if(mutant != 0) ratio =  (mutant / human);
        response.onCallback((int)human,(int)mutant,ratio);
    }

    private boolean validateIsMutant(Dna dna){
        return dna.isMutant();
    }
}
