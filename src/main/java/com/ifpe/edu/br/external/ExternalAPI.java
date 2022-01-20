package com.ifpe.edu.br.external;

import com.ifpe.edu.br.models.CreditCardCredentials;
import com.ifpe.edu.br.models.exceptions.CardDoesNotHaveLimitException;

public class ExternalAPI {

    public Integer debit(CreditCardCredentials creditCardCredentials, Double value) throws CardDoesNotHaveLimitException {
       Boolean a = this.checkLimit(creditCardCredentials);
        if(a)
            return 200;
        throw new CardDoesNotHaveLimitException("Card doesn't have limit!");
    }

    /*
    * Method created just to mock its return */
    public Boolean checkLimit(CreditCardCredentials credentials) {
        return true;
    }
}
