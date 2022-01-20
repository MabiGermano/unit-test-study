package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.CandidateVacancy;
import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.PasswordException;
import com.ifpe.edu.br.models.exceptions.UserHasNotPackageException;
import com.ifpe.edu.br.repository.CandidateVacancyRepository;
import com.ifpe.edu.br.repository.UserRepository;
import com.ifpe.edu.br.service.impl.CandidateVacancyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CandidateVacancyTest {

    private GeneralInstances instances = new GeneralInstances();
    private CandidateVacancyService candidateVacancyService = new CandidateVacancyServiceImpl();

    @Test
    public void generateCertificate() {

        StringBuilder expectedCertificate = new StringBuilder("Certificado de cumprimento de atividade");
        expectedCertificate.append("/n");
        expectedCertificate.append("Atesto para devidos fins que ");
        expectedCertificate.append("Maria");
        expectedCertificate.append("prestou serviço voluntário no cumprimento de atividades em ");
        expectedCertificate.append("Hotelzinho para cães e gatos em Recife");

    String generatedCertificate = candidateVacancyService
            .generateCertificate(instances.candidateVacancy1);

        Assertions.assertEquals(
                expectedCertificate.toString(),generatedCertificate);
    }
    @Test
    public void generateCertificateUserDoesNotHavePackage() {

        CandidateVacancy candidateVacancyWithoutPackage = instances.candidateVacancy2;
        UserHasNotPackageException exception = assertThrows(UserHasNotPackageException.class,
                () -> candidateVacancyService.generateCertificate(candidateVacancyWithoutPackage));

        assertEquals(exception.getMessage(), "User has not package");
    }
}


