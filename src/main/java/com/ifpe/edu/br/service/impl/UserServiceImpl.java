package com.ifpe.edu.br.service.impl;

import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.EmailException;
import com.ifpe.edu.br.models.exceptions.EmptyFieldException;
import com.ifpe.edu.br.models.exceptions.PasswordException;
import com.ifpe.edu.br.repository.UserRepository;
import com.ifpe.edu.br.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void criarUsuario(User user) throws RuntimeException {
        validaSenha(user.getPassword());
        if(UserRepository.getInstance().containEmail(user.getEmail()))
            throw new EmailException("Email já está cadastrado");
        validaCamposVazios(user);
        UserRepository.getInstance().add(user);
    }

    private void validaSenha(String senha) throws PasswordException {
        if(senha.length() < 8)
            throw new PasswordException("Senha com menos de 8 caracteres");
        else if(senha.length() > 64)
            throw new PasswordException("Senha com mais de 64 caracteres");
        else if(senha.contains("^[a-Z]"))
            throw new PasswordException("Senha não contém letra");
        else if(!senha.matches(".*\\d.*"))
            throw new PasswordException("Senha não contém número");
    }

    private void validaCamposVazios(User user){
        if (user.getName() == null || user.getName().isEmpty() || user.getName().isBlank())
            throw new EmptyFieldException("O campo de nome não está preenchido");
        else if (user.getBirthDate() == null)
            throw new EmptyFieldException("O campo de data de nascimento não está preenchido");
        else if (user.getIdentityRegistration() == null || user.getIdentityRegistration().isEmpty() || user.getIdentityRegistration().isBlank())
            throw new EmptyFieldException("O campo de cpf/cnjp não está preenchido");
        else if (user.getAddress().getZipcode() == null || user.getAddress().getZipcode().isEmpty() || user.getAddress().getZipcode().isBlank())
            throw new EmptyFieldException("O campo de cep do endereço não está preenchido");
        else if (user.getAddress().getStreet() == null || user.getAddress().getStreet().isEmpty() || user.getAddress().getStreet().isBlank())
            throw new EmptyFieldException("O campo de rua do endereço não está preenchido");
        else if (user.getAddress().getNumber() == null || user.getAddress().getNumber().isEmpty() || user.getAddress().getNumber().isBlank())
            throw new EmptyFieldException("O campo de número do endereço não está preenchido");
        else if (user.getAddress().getDistrict() == null || user.getAddress().getDistrict().isEmpty() || user.getAddress().getDistrict().isBlank())
            throw new EmptyFieldException("O campo de bairro do endereço não está preenchido");
        else if (user.getAddress().getState() == null || user.getAddress().getState().isEmpty() || user.getAddress().getState().isBlank())
            throw new EmptyFieldException("O campo de estado do endereço não está preenchido");
        else if (user.getAddress().getCity() == null || user.getAddress().getCity().isEmpty() || user.getAddress().getCity().isBlank())
            throw new EmptyFieldException("O campo de cidade do endereço não está preenchido");
        else if (user.getAddress().getCountry() == null || user.getAddress().getCountry().isEmpty() || user.getAddress().getCountry().isBlank())
            throw new EmptyFieldException("O campo de país do endereço não está preenchido");
    }
}
