package com.mercadolibre.challenge.infraestructure.rest.dto;

public class StatDto {

    private final int countMutantDna;
    private final int countHumanDna;
    private final double ratio;

    public StatDto(int countMutantDna, int countHumanDna, double ratio) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.ratio = ratio;
    }

    public int getCountMutantDna() {
        return countMutantDna;
    }

    public int getCountHumanDna() {
        return countHumanDna;
    }

    public double getRatio() {
        return ratio;
    }
}
