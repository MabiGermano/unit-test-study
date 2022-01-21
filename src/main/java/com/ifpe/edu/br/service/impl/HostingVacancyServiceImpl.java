package com.ifpe.edu.br.service.impl;

import com.ifpe.edu.br.models.HostingVacancy;
import com.ifpe.edu.br.models.exceptions.UserExistException;
import com.ifpe.edu.br.repository.HostingVacancyRepository;
import com.ifpe.edu.br.service.HostingVacancyService;

public class HostingVacancyServiceImpl implements HostingVacancyService {
    @Override
    public void editarVaga(HostingVacancy hostingVacancy) {
        if(hostingVacancy.getUser() != null){
            throw new UserExistException("Vaga não pode ser editada, pois possui um usuário");
        }
        HostingVacancyRepository.getInstance().update(hostingVacancy);
    }

    @Override
    public void arquivarVaga(int id) {

    }
}
