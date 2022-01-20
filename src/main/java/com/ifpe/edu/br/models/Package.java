package com.ifpe.edu.br.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Package {
    private String description;
    private char code;
    private Double value;
}
