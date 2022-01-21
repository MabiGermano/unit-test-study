package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.HostingVacancy;

public interface HostingVacancyService {

    void editarVaga(HostingVacancy hostingVacancy);

    void arquivarVaga(int id);
}
