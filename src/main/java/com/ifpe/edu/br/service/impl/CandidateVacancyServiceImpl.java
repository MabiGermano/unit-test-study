package com.ifpe.edu.br.service.impl;


import com.ifpe.edu.br.models.CandidateVacancy;
import com.ifpe.edu.br.models.exceptions.UserHasNotPackageException;
import com.ifpe.edu.br.service.CandidateVacancyService;

public class CandidateVacancyServiceImpl implements CandidateVacancyService {

    @Override
    public String generateCertificate(CandidateVacancy candidateVacancy) {
        if (candidateVacancy.getUser().getAPackage() == null)
            throw new UserHasNotPackageException("User has not package");
        return candidateVacancy.getCertificateNote();
    }
}
