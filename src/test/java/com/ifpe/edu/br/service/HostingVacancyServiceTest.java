package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.HostingVacancy;
import com.ifpe.edu.br.models.exceptions.UserExistException;
import com.ifpe.edu.br.repository.HostingVacancyRepository;
import com.ifpe.edu.br.service.impl.HostingVacancyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HostingVacancyServiceTest {

    private GeneralInstances generalInstances = new GeneralInstances();
    private HostingVacancyService hostingVacancyService = new HostingVacancyServiceImpl();

    @BeforeEach
    public void initEach(){
        HostingVacancy hostingVacancy = generalInstances.hostingVacancy1;
        HostingVacancyRepository.getInstance().add(hostingVacancy);
    }

    @Test
    public void editarVagaComSucesso(){
        String newDescription = "Alguma nova descrição";
        HostingVacancy hostingVacancy = HostingVacancyRepository.getInstance().getById(0);
        hostingVacancy.setDescription(newDescription);
        hostingVacancyService.editarVaga(hostingVacancy);
        HostingVacancy hostingVacancyUpdated = HostingVacancyRepository.getInstance().getById(0);
        assertEquals(newDescription, hostingVacancyUpdated.getDescription());
    }

    @Test
    public void editarVagaDarErroPorPossuirUsuario(){
        String newDescription = "Alguma nova descrição";
        HostingVacancy hostingVacancy = HostingVacancyRepository.getInstance().getById(0);
        assertNotNull(hostingVacancy.getUser());
        hostingVacancy.setDescription(newDescription);
        UserExistException userExistException = assertThrows(UserExistException.class, () -> {
            hostingVacancyService.editarVaga(hostingVacancy);
        });
        assertEquals("Vaga não pode ser editada, pois possui um usuário", userExistException.getMessage());
    }
}