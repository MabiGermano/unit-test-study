package com.ifpe.edu.br.service;

import com.ifpe.edu.br.models.CreditCardCredentials;
import com.ifpe.edu.br.models.Package;
import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.CardDoesNotHaveLimitException;

public interface PackageService {
    public String generateBillToPay(Package aPackage);
    public void buyWithCreditCard(User user, Package aPackage, CreditCardCredentials creditCardCredentials) throws CardDoesNotHaveLimitException;
}
