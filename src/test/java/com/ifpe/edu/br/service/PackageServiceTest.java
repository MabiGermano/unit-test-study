package com.ifpe.edu.br.service;

import com.ifpe.edu.br.external.ExternalAPI;
import com.ifpe.edu.br.models.CreditCardCredentials;
import com.ifpe.edu.br.models.User;
import com.ifpe.edu.br.models.exceptions.CardDoesNotHaveLimitException;
import com.ifpe.edu.br.models.exceptions.WrongCreditCardCredentialsException;
import com.ifpe.edu.br.repository.UserRepository;
import com.ifpe.edu.br.service.impl.PackageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PackageServiceTest {

    private GeneralInstances instances = new GeneralInstances();

    @Mock
    private ExternalAPI externalAPI = new ExternalAPI();

    private PackageServiceImpl packageService = new PackageServiceImpl(externalAPI);

    @BeforeEach
    public void setUp() {
        UserRepository.getInstance().add(instances.user2);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void generateBillToPay() {

        Date dueDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dueDate);
        c.add(Calendar.DATE, 3);
        dueDate = c.getTime();

        StringBuilder expectedBill = new StringBuilder("Boleto bancário para pagamento");
        expectedBill.append("\n");
        expectedBill.append("Data de vencimento: ");
        expectedBill.append(dueDate);
        expectedBill.append("\n");
        expectedBill.append("Valor a Pagar: R$ ");
        expectedBill.append(49.90);
        expectedBill.append("Senhor caixa, favor não aceitar pagamento fora da data de vencimento");

        Assertions.assertEquals(
                expectedBill.toString(), packageService.generateBillToPay(instances.aPackage1));
    }


    @Test
    public void buyAPackageWithCreditCard() throws CardDoesNotHaveLimitException {
        User createdUser = UserRepository.getInstance().getById(0);
        Assertions.assertNull(createdUser.getAPackage());

        packageService
                .buyWithCreditCard(createdUser,
                        instances.aPackage1,
                        instances.credentials);

        Assertions
                .assertNotNull(UserRepository
                        .getInstance()
                        .getById(0)
                        .getAPackage());
    }

    @Test
    public void buyAPackageWithNoLimitCreditCard() {

        Mockito.when(externalAPI.checkLimit(Mockito.any(CreditCardCredentials.class))).thenReturn(false);

        User createdUser = UserRepository.getInstance().getById(0);

        Assertions.assertThrows(CardDoesNotHaveLimitException.class, () -> packageService
                .buyWithCreditCard(createdUser,
                        instances.aPackage1,
                        instances.credentials));
    }

    @Test
    public void buyAPackageWithWrongCreditCardCredentials() {
//        Mockito.doReturn(false)
//                .when(Mockito.mock(CreditCardCredentials.class))
//                .isRightCredentials();

        User createdUser = UserRepository.getInstance().getById(0);

        Assertions.assertThrows(WrongCreditCardCredentialsException.class, () -> packageService
                .buyWithCreditCard(createdUser,
                        instances.aPackage1,
                        instances.credentials));
    }

}