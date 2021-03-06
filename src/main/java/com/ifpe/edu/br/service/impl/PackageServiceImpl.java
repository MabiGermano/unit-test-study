package com.ifpe.edu.br.service.impl;

import com.ifpe.edu.br.external.ExternalAPI;
import com.ifpe.edu.br.models.CreditCardCredentials;
import com.ifpe.edu.br.models.Package;
import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.CardDoesNotHaveLimitException;
import com.ifpe.edu.br.models.exceptions.WrongCreditCardCredentialsException;
import com.ifpe.edu.br.repository.UserRepository;
import com.ifpe.edu.br.service.PackageService;

import java.util.Calendar;
import java.util.Date;

public class PackageServiceImpl implements PackageService {

    private ExternalAPI externalAPI = new ExternalAPI();

    public PackageServiceImpl(){}

    public PackageServiceImpl(ExternalAPI externalAPI){
        this.externalAPI = externalAPI;
    }
    @Override
    public String generateBillToPay(Package aPackage) {

        Date dueDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dueDate);
        c.add(Calendar.DATE, 3);
        dueDate = c.getTime();

        StringBuilder billToPay = new StringBuilder("Boleto bancário para pagamento");
        billToPay.append("\n");
        billToPay.append("Data de vencimento: ");
        billToPay.append(dueDate);
        billToPay.append("\n");
        billToPay.append("Valor a Pagar: R$ ");
        billToPay.append(aPackage.getValue());
        billToPay.append("Senhor caixa, favor não aceitar pagamento fora da data de vencimento");

        return billToPay.toString();
    }

    @Override
    public void buyWithCreditCard(User user, Package aPackage, CreditCardCredentials creditCardCredentials) throws CardDoesNotHaveLimitException {
        if (!creditCardCredentials.isRightCredentials())
            throw new WrongCreditCardCredentialsException("Wrong credit card credentials");
        Integer statusCode = externalAPI.debit(creditCardCredentials, aPackage.getValue());
        if(statusCode == 200)
            user.setAPackage(aPackage);

        UserRepository.getInstance().update(user);
    }
}
