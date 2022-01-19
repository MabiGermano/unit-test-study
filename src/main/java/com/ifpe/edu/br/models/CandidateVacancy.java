package com.ifpe.edu.br.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CandidateVacancy {
    private int id;
    private User user;
    private HostingVacancy hostingVacancy;
    private char situation;
    private Date startDate;
    private Date endDate;
    private String description;
    private Certificate certificate;
}
