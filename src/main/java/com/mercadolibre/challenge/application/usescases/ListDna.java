package com.mercadolibre.challenge.application.usescases;

import com.mercadolibre.challenge.domain.services.DnaService;

import java.util.ArrayList;
import java.util.List;

public class ListDna {

    private final DnaService dnaService;
    private List<String> listDna;

    public ListDna(DnaService dnaService) {
        this.dnaService = dnaService;
        listDna = new ArrayList<>();
    }

    public void execute(){
        this.dnaService.listDna(dna -> {
            listDna = dna;
        });
    }

    public List<String> getListDna() {
        return listDna;
    }

}
