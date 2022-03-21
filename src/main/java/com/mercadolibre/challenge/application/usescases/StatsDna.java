package com.mercadolibre.challenge.application.usescases;

import com.mercadolibre.challenge.domain.services.DnaService;

public class StatsDna {

    private final DnaService service;
    private int countHuman;
    private int countMutant;
    private double ratioMutant;

    public StatsDna(DnaService service) {
        this.service = service;
        this.countHuman = 0;
        this.countMutant = 0;
        this.ratioMutant = 0;
    }

    public void execute(){
        service.count((humans, mutants, ratio) -> {
            this.countHuman = humans;
            this.countMutant = mutants;
            this.ratioMutant = ratio;
        });
    }

    public int getCountHuman() {
        return countHuman;
    }

    public int getCountMutant() {
        return countMutant;
    }

    public double getRatio() {
        return ratioMutant;
    }
}
