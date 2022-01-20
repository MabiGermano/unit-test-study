package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.Address;
import com.ifpe.edu.br.models.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private User criarUsuario(){
        Address address = Address.builder().city("Recife")
                .country("Brasil")
                .district("dos bobos")
                .street("Rua dos bobos")
                .state("PE")
                .number("11")
                .zipcode("25698965").build();

        return User.builder()
                .address(address)
                .email("mbges@discente.ifpe.edu.br")
                .name("Maria")
                .birthDate(new Date("06/03/1997"))
                .bioDescription("estudante de Análise e desenvolvimento de sistemas")
                .identityRegistration("58965986536")
                .password("ZSE$xdr5").build();
    }

}