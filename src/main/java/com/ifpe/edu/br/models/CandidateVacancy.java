package com.ifpe.edu.br.models;

import com.ifpe.edu.br.models.exceptions.UserHasNotPackageException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class CandidateVacancy {
    private int id;
    private User user;
    private HostingVacancy hostingVacancy;
    private char situation;
    private Date startDate;
    private Date endDate;
    private String description;

    public String getCertificateNote() {
        StringBuilder certificateNote = new StringBuilder("Certificado de cumprimento de atividade");
        certificateNote.append("/n");
        certificateNote.append("Atesto para devidos fins que ");
        certificateNote.append(this.user.getName());
        certificateNote.append("prestou serviço voluntário no cumprimento de atividades em ");
        certificateNote.append(this.hostingVacancy.getDescription());
        return certificateNote.toString();
    }
}
