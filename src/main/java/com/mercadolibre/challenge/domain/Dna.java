package com.mercadolibre.challenge.domain;

import com.mercadolibre.challenge.domain.exceptions.InvalidStructureDnaException;
import com.mercadolibre.challenge.domain.services.validate.AdnValidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@RequiredArgsConstructor
public class Dna {

    private final static String patternAdn = "[ATGC]+";

    @Getter
    private String[] chains;

    public void isExitsLetter() throws InvalidStructureDnaException {
        int i = 0;
        for (String s : this.chains) {
            Pattern pattern = Pattern.compile(patternAdn, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(s);
            if(!matcher.matches()){
               i++;
            }
        }
        if(i != 0){
            throw new InvalidStructureDnaException("Not Found Letter [ACGT]");
        }
    }

    public void isStructure() throws InvalidStructureDnaException {
         int row = this.chains.length;
         if(row >= 4){
             for (int i = 0 ; i < row ; i++) {
                 this.chains[i] = this.chains[i].toUpperCase();
                 if(this.chains[i].length() != row){
                     throw new InvalidStructureDnaException("Invalid Structure DNA: "+this.chains[i]);
                 }
             }
         }else {
             throw new InvalidStructureDnaException("Invalid Structure Rows: "+row);
         }
    }

    public boolean isMutant(){
        return new AdnValidate().isMutant(this.getChains());
    }

}
