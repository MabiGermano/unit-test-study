package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.CandidateVacancy;
import com.ifpe.edu.br.models.exceptions.UserHasNotPackageException;

public interface CandidateVacancyService {

    String generateCertificate(CandidateVacancy candidateVacancy);
}
