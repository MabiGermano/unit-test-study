package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.Certificate;

import java.util.ArrayList;
import java.util.List;

public class CertificateRepository {

    private List<Certificate> certificates;

    private CertificateRepository certificateRepository;

    private CertificateRepository(){}

    public CertificateRepository getInstance(){
        if(certificateRepository == null){
            certificates = new ArrayList<>();
            certificateRepository = new CertificateRepository();
        }
        return certificateRepository;
    }

    public void add(Certificate certificate){
        certificates.add(certificate);
    }

    public List<Certificate> getAll(){
        return certificates;
    }
}
