package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.CandidateVacancy;

import java.util.ArrayList;
import java.util.List;

public class CandidateVacancyRepository {

    private List<CandidateVacancy> candidateVacancies;

    private static CandidateVacancyRepository candidateVacancyRepository;

    private CandidateVacancyRepository(){
        candidateVacancies = new ArrayList<>();
    }

    public static CandidateVacancyRepository getInstance(){
        if(candidateVacancyRepository == null){
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
