package com.ifpe.edu.br.models.exceptions;

public class EmptyFieldException extends RuntimeException{
    public EmptyFieldException(String msg){
        super(msg);
    }
}
