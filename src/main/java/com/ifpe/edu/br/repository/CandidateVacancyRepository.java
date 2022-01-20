package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.CandidateVacancy;

import java.util.ArrayList;
import java.util.List;

public class CandidateVacancyRepository {

    private List<CandidateVacancy> candidateVacancies;

    private CandidateVacancyRepository candidateVacancyRepository;

    private CandidateVacancyRepository(){}

    public CandidateVacancyRepository getInstance(){
        if(candidateVacancyRepository == null){
            candidateVacancies = new ArrayList<>();
            candidateVacancyRepository = new CandidateVacancyRepository();
        }
        return candidateVacancyRepository;
    }

    public void add(CandidateVacancy candidateVacancy){
        candidateVacancy.setId(candidateVacancies.size());
        candidateVacancies.add(candidateVacancy);
    }

    public CandidateVacancy getById(int id){
        return candidateVacancies.get(id);
    }
}
