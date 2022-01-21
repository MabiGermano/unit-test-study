package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.HostingVacancy;

import java.util.ArrayList;
import java.util.List;

public class HostingVacancyRepository {

    private List<HostingVacancy> hostingVacancies;

    private static HostingVacancyRepository hostingVacancyRepository;

    private HostingVacancyRepository(){
        hostingVacancies = new ArrayList<>();
    }

    public static HostingVacancyRepository getInstance(){
        if(hostingVacancyRepository == null){
            hostingVacancyRepository = new HostingVacancyRepository();
        }
        return hostingVacancyRepository;
    }

    public void add(HostingVacancy hostingVacancy){
        hostingVacancy.setId(hostingVacancies.size());
        hostingVacancies.add(hostingVacancy);
    }

    public HostingVacancy getById(int id){
        return hostingVacancies.get(id);
    }

    public void update(HostingVacancy hostingVacancy){
        hostingVacancies.add(hostingVacancy.getId(), hostingVacancy);
    }
}
