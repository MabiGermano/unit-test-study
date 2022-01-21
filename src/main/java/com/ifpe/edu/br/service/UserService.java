package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.PasswordException;

public interface UserService {

    void criarUsuario(User user) throws RuntimeException;
}
