package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.Address;
import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.EmailException;
import com.ifpe.edu.br.models.exceptions.PasswordException;
import com.ifpe.edu.br.repository.UserRepository;
import com.ifpe.edu.br.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserServiceImpl userService = new UserServiceImpl();
    private GeneralInstances instances = new GeneralInstances();

    @Test
    public void deveCriarUsuarioCorretamente(){
        User usuarioMock = instances.user1;
        userService.criarUsuario(usuarioMock);
        User usuarioPersist = UserRepository.getInstance().getById(0);

        assertNotNull(usuarioPersist);
        assertEquals(usuarioMock.getAddress(), usuarioPersist.getAddress());
        assertEquals(usuarioMock.getName(), usuarioPersist.getName());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaComMenosDe8Caracteres(){
        User usuarioMock = instances.user1;
        usuarioMock.setPassword("e430");
        PasswordException passwordException = assertThrows(PasswordException.class,
                () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha com menos de 8 caracteres");
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaComMaisDe64Caracteres(){
        User usuarioMock = UserRepository.getInstance().getById(0);
        PasswordException passwordException = assertThrows(PasswordException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha com mais de 64 caracteres");
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaSemLetraNaSenha(){
        User usuarioMock = UserRepository.getInstance().getById(0);
        PasswordException passwordException = assertThrows(PasswordException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha não contém letra");
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaSemNumeroNaSenha(){
        User usuarioMock = UserRepository.getInstance().getById(0);
        PasswordException passwordException = assertThrows(PasswordException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha não contém número");
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaSemEmail(){
        User usuarioMock = UserRepository.getInstance().getById(0);
        EmailException emailException = assertThrows(EmailException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emailException.getMessage(), "Usuário não contém email");
        assertNull(usuarioMock.getEmail());
    }
}