package com.ifpe.edu.br.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class User {
    private int id;
    private Address address;
    private String name;
    private String identityRegistration;
    private String email;
    private String password;
    private String gender;
    private String bioDescription;
    private Date birthDate;
    private Package aPackage;
}
