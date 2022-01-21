package com.ifpe.edu.br.models.exceptions;

public class WrongCreditCardCredentialsException extends RuntimeException {
    public WrongCreditCardCredentialsException(String msg) {
        super(msg);
    }
}
