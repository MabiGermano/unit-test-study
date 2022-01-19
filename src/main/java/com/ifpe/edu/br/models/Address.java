package com.ifpe.edu.br.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private int id;
    private String country;
    private String state;
    private String city;
    private String district;
    private String street;
    private String number;
    private String zipcode;
}
