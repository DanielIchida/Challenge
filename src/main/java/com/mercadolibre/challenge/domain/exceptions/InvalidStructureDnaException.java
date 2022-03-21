package com.mercadolibre.challenge.domain.exceptions;

public class InvalidStructureDnaException extends Exception {

    private final String message;

    public InvalidStructureDnaException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
