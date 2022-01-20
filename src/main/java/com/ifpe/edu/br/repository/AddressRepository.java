package com.ifpe.edu.br.repository;

import com.ifpe.edu.br.models.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressRepository {

    private List<Address> addresses;

    private static AddressRepository addressRepository;

    private AddressRepository(){
        addresses = new ArrayList<>();
    }

    public static AddressRepository getInstance(){
        if (addressRepository == null){
            addressRepository = new AddressRepository();
        }
        return addressRepository;
    }

    public void addAddress(Address address){
        address.setId(addresses.size());
        addresses.add(address);
    }

    public Address findById(int id){
        return addresses.get(id);
    }
}
