package com.mercadolibre.challenge.infraestructure.rest.controllers;

import com.mercadolibre.challenge.application.usescases.ListDna;
import com.mercadolibre.challenge.application.usescases.SaveDna;
import com.mercadolibre.challenge.application.usescases.StatsDna;
import com.mercadolibre.challenge.domain.exceptions.InvalidStructureDnaException;
import com.mercadolibre.challenge.infraestructure.rest.dto.RequestDna;
import com.mercadolibre.challenge.infraestructure.rest.dto.StatDto;
import com.mercadolibre.challenge.infraestructure.rest.dto.ValidateDnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdnController {

    @Autowired
    private SaveDna saveDna;

    @Autowired
    private StatsDna statsDna;

    @Autowired
    private ListDna listDna;

    @PostMapping("/mutant")
    public ResponseEntity<ValidateDnaDto> mutant(@RequestBody RequestDna request) throws InvalidStructureDnaException {
        saveDna.execute(request.getDna());
        ValidateDnaDto response = new ValidateDnaDto(saveDna.isValidateAdn());
        if(response.isMutant()){
           return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
           return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatDto> stats(){
          statsDna.execute();
          StatDto response = new StatDto(
                  statsDna.getCountMutant(),
                  statsDna.getCountHuman(),
                  statsDna.getRatio()
          );
          return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/dnas")
    public ResponseEntity<String[]> list(){
        listDna.execute();
        return new ResponseEntity(listDna.getListDna(),HttpStatus.OK);
    }

}
