package com.ifpe.edu.br.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class CreditCardCredentials {
    private String number;
    private String holder;
    private Date dueDate;
    private String cvv;
}
