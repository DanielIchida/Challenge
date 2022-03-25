package com.mercadolibre.challenge.infraestructure.rest.config;

import com.mercadolibre.challenge.application.repositories.DnaRepository;
import com.mercadolibre.challenge.application.usescases.ListDna;
import com.mercadolibre.challenge.application.usescases.SaveDna;
import com.mercadolibre.challenge.application.usescases.StatsDna;

import com.mercadolibre.challenge.domain.services.DnaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DnaBean {

    @Bean
    public DnaService dnaService(DnaRepository repository){
        return new DnaService(repository);
    }

    @Bean
    public SaveDna saveDna(DnaService service){
        return new SaveDna(service);
    }

    @Bean
    public StatsDna statsDna(DnaService service){
        return new StatsDna(service);
    }

    @Bean
    public ListDna listDna(DnaService service){
        return new ListDna(service);
    }

}
