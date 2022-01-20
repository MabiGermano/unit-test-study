package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageRepository {

    private List<Package> packages;

    private PackageRepository packageRepository;

    private PackageRepository(){}

    public PackageRepository getInstance(){
        if(packageRepository == null){
            packages = new ArrayList<>();
            packageRepository = new PackageRepository();
        }
        return packageRepository;
    }

    public void add(Package aPackage){
        packages.add(aPackage);
    }

    public List<Package> getByAll(){
        return packages;
    }
}
