package com.mercadolibre.challenge.application.repositories;


import java.util.List;

public interface DnaRepository {
    void addAdn(String chains);
    List<String> allDna();
}
