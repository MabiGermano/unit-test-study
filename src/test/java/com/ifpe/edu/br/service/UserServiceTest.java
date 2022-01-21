package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.EmailException;
import com.ifpe.edu.br.models.exceptions.PasswordException;
import com.ifpe.edu.br.models.exceptions.EmptyFieldException;
import com.ifpe.edu.br.repository.UserRepository;
import com.ifpe.edu.br.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private GeneralInstances generalInstances = new GeneralInstances();

    private UserService userService = new UserServiceImpl();

    @Test
    public void deveCriarUsuarioCorretamente(){
        User usuarioMock = generalInstances.user1;
        userService.criarUsuario(usuarioMock);
        User usuarioPersist = UserRepository.getInstance().getById(0);

        assertNotNull(usuarioPersist);
        assertEquals(usuarioMock.getAddress(), usuarioPersist.getAddress());
        assertEquals(usuarioMock.getName(), usuarioPersist.getName());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaComMenosDe8Caracteres(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.setPassword("ZSE$x");
        PasswordException passwordException = assertThrows(PasswordException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha com menos de 8 caracteres");
        usuarioMock.setPassword("ZSE$xdr5");
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaComMaisDe64Caracteres(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.setPassword("1qaz@WSX3edc$RFV5tgb¨YHN7ujm*IK<9ol.)PÇ:-´~+{}!QAZ2wsx#EDC4rfv%TGB6yhn");
        PasswordException passwordException = assertThrows(PasswordException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha com mais de 64 caracteres");
        usuarioMock.setPassword("ZSE$xdr5");
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemLetraNaSenha(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.setPassword("12345678");
        PasswordException passwordException = assertThrows(PasswordException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha não contém letra");
        usuarioMock.setPassword("ZSE$xdr5");
    }

    @Test
    public void deveDarErroAoCriarUsuarioSenhaSemNumeroNaSenha(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.setPassword("qazWSXedcRFV");
        PasswordException passwordException = assertThrows(PasswordException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(passwordException.getMessage(), "Senha não contém número");
        usuarioMock.setPassword("ZSE$xdr5");
    }

    @Test
    public void deveDarErroAoCriarUsuarioComEmailRepetido(){
        User usuarioMock = generalInstances.user1;
        EmailException emailException = assertThrows(EmailException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emailException.getMessage(), "Email já está cadastrado");
        assertNull(usuarioMock.getEmail());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemNome(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.setName(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de nome não está preenchido");
        assertNull(usuarioMock.getName());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemDataNascimento(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.setBirthDate(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de data de nascimento não está preenchido");
        assertNull(usuarioMock.getBirthDate());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemIdentidade(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.setIdentityRegistration(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de cpf/cnjp não está preenchido");
        assertNull(usuarioMock.getIdentityRegistration());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemCepDoEndereco(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.getAddress().setZipcode(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de cep do endereço não está preenchido");
        assertNull(usuarioMock.getAddress().getZipcode());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemRuaDoEndereco(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.getAddress().setStreet(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de rua do endereço não está preenchido");
        assertNull(usuarioMock.getAddress().getStreet());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemNumeroDoEndereco(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.getAddress().setNumber(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de número do endereço não está preenchido");
        assertNull(usuarioMock.getAddress().getNumber());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemBairroDoEndereco(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.getAddress().setDistrict(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de bairro do endereço não está preenchido");
        assertNull(usuarioMock.getAddress().getDistrict());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemEstadoDoEndereco(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.getAddress().setState(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de estado do endereço não está preenchido");
        assertNull(usuarioMock.getAddress().getState());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemCidadeDoEndereco(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.getAddress().setCity(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de cidade do endereço não está preenchido");
        assertNull(usuarioMock.getAddress().getCity());
    }

    @Test
    public void deveDarErroAoCriarUsuarioSemPaisDoEndereco(){
        User usuarioMock = generalInstances.user1;
        usuarioMock.getAddress().setCountry(null);
        EmptyFieldException emptyFieldException = assertThrows(EmptyFieldException.class, () -> userService.criarUsuario(usuarioMock));

        assertEquals(emptyFieldException.getMessage(), "O campo de país do endereço não está preenchido");
        assertNull(usuarioMock.getAddress().getCountry());
    }
}