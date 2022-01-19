package com.ifpe.edu.br.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HostingVacancy {
    private int id;
    private User user;
    private Address address;
    private String title;
    private String description;
    private char situation;
    private int minWeek;
    private int maxWeek;
    private int workTimeAtWeek;
}
