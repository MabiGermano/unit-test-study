package com.ifpe.edu.br.models.exceptions;

public class UserExistException extends RuntimeException{
    public UserExistException(String msg){
        super(msg);
    }
}
