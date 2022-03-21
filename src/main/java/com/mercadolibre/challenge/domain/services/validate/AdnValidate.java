package com.mercadolibre.challenge.domain.services.validate;


public class AdnValidate {

    char[] letters = {'T','C','G','A'};

    public boolean isMutant(String[] dna){
        int patternCount = 0;
        char[][] convertDna = covertTwoDimensional(dna);
        for (int l = 0 ; l < letters.length ; l++) {
            for (int i = 0; i < convertDna.length; i++) {
                for (int j = 0; j < convertDna.length; j++) {
                    patternCount =  patternCount+ horizontalVerticalSearch(i,j,convertDna,letters[l],PositionEnum.HORIZONTAL);
                    patternCount = patternCount + horizontalVerticalSearch(i,j,convertDna,letters[l],PositionEnum.VERTICAL);
                    patternCount = patternCount + diagonalLeftRigthTopSearch(i,j,convertDna,letters[l],PositionEnum.LEFT);
                    patternCount = patternCount + diagonalLeftRigthTopSearch(i,((convertDna.length - 1) - j),convertDna,letters[l],PositionEnum.RIGHT);
                    patternCount = patternCount + diagonalLeftRightBottomSearch(((convertDna.length - 1) - i),j,convertDna,letters[l],PositionEnum.LEFT);
                    patternCount = patternCount + diagonalLeftRightBottomSearch(((convertDna.length - 1) - i),((convertDna.length - 1) - j),convertDna,letters[l],PositionEnum.RIGHT);
                }
            }
        }
        return patternCount > 1;
    }

    //TODO METODO PARA CONVERTIR DE UNA ARREGLO DE STRING A UNA MATRIZ CHAR
    private char[][] covertTwoDimensional(String[] dna){
        char[][] dna2 = new char[dna.length][dna.length];
        for (int i = 0; i < dna.length; i++) {
            char[] lettersCurrent = dna[i].toCharArray();
            for (int j = 0; j < lettersCurrent.length; j++) {
                dna2[i][j] = lettersCurrent[j];
            }
        }
        return dna2;
    }
    //TODO N NUMERO DE PATRONES DE MANERA HORIZONTAL Y VERTICAL
    private int horizontalVerticalSearch(int i , int j, char[][] letters,char letter,PositionEnum positionEnum){
        int chainsNumber = 0;
        int letterCount = 0;
        if(letters[i][j] == letter) {
            if(positionEnum == PositionEnum.HORIZONTAL) {
                for (int c = j; c < 4; c++) {
                    if (letters[i][c] == letter) {
                        letterCount++;
                    } else {
                        break;
                    }
                }
            }else{
                for(int c = i ; c < 4 ; c++){
                    if(letters[c][j] == letter){
                        letterCount++;
                    }else{
                        break;
                    }
                }
            }
            if(letterCount > 3){
                chainsNumber++;
            }
        }
        return chainsNumber;
    }

    //TODO N NUMERO DE PATRONES DE MANERA DERECHA A IZQUIERDA HACIA ARRIBA
    public static int diagonalLeftRigthTopSearch(int i , int j, char[][] letters, char letter, PositionEnum positionEnum){
        int chainsNumber = 0;
        int letterCount = 0;

        int numberPosicionValidate = 4;
        if (positionEnum == PositionEnum.RIGHT) {
            numberPosicionValidate = 5;
        }

        if(letters[i][j] == letter) {
            int countColum = i;
            int size = letters.length - 1;
            if(countColum == size){
                return 0;
            }
            for(int c = j; c < numberPosicionValidate ; c++){
                if(countColum > size){
                    break;
                }
                if(letters[countColum][c] == letter){
                    countColum = countColum + 1;
                    letterCount++;
                }else{
                    break;
                }
            }
        }
        if(letterCount > 3){
            chainsNumber++;
        }
        return chainsNumber;
    }

    //TODO N NUMERO DE PATRONES DE MANERA DERECHA A IZQUIERDA HACIA ABAJO
    public static int diagonalLeftRightBottomSearch(int i , int j, char[][] letters,char letter,PositionEnum positionEnum){
        int chainsNumber = 0;
        int letterCount = 0;
        int numberPosicionValidate = 4;
        boolean posValidateLeft = true;
        if(positionEnum == PositionEnum.RIGHT){
            numberPosicionValidate = 6;
            posValidateLeft = false;
        }
        if(letters[i][j] == letter) {
            int countColum = i;
            int countRow = j;
            if(countColum < 0){
                return 0;
            }
            for(int c = countRow; c < numberPosicionValidate ; c++){
                int size = letters.length - 1;
                if(posValidateLeft){
                    if(countColum < 0 || countColum > size){
                        break;
                    }
                }else{
                    if(countColum < 0){
                        break;
                    }
                }
                if(letters[countColum][c] == letter){
                    if(posValidateLeft){
                        countRow = countRow - 1;
                        countColum = countColum + 1;
                    }else{
                        countRow = countRow + 1;
                        countColum = countColum - 1;
                    }
                    letterCount = letterCount + 1;
                }else{
                    break;
                }
            }
        }
        if(letterCount > 3){
            chainsNumber++;
        }
        return chainsNumber;
    }


}
