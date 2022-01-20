import com.ifpe.edu.br.models.*;
import com.ifpe.edu.br.models.Package;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

public class GeneralInstances {

    Address address1 = Address.builder().city("Recife")
            .country("Brasil")
            .district("dos bobos")
            .street("Rua dos bobos")
            .state("PE")
            .number("11")
            .zipcode("25698965").build();

    Address address2 = Address.builder().city("São Paulo")
            .country("Brasil")
            .district("Liberdade")
            .street("Rua dos Ypês")
            .state("SP")
            .number("24")
            .zipcode("15822987").build();


    User user1 = User.builder()
                .address(address1)
                .email("mbges@discente.ifpe.edu.br")
                .name("Maria")
                .birthDate(new Date("06/03/1997"))
            .bioDescription("estudante de Análise e desenvolvimento de sistemas")
                .identityRegistration("58965986536")
                .password("ZSE$xdr5").build();

    User user2 = User.builder()
            .address(address2)
            .email("jvnb@discente.ifpe.edu.br")
            .name("João")
            .birthDate(new Date("20/06/2000"))
            .bioDescription("estudante de Análise e desenvolvimento de sistemas")
            .identityRegistration("85996325882")
            .password("BGT%cft7").build();

    HostingVacancy hostingVacancy1 = HostingVacancy.builder()
            .address(address2)
            .description("Software house no centro de são paulo")
            .maxWeek(8)
            .minWeek(2)
            .situation('0')
            .workTimeAtWeek(40)
            .user(user2).build();

    HostingVacancy hostingVacancy2 = HostingVacancy.builder()
            .address(address1)
            .description("Hotelzinho para cães e gatos em Recife")
            .maxWeek(10)
            .minWeek(4)
            .situation('0')
            .workTimeAtWeek(40)
            .user(user1).build();

    Package aPackage1 = Package.builder()
            .code('1')
            .value(49.90)
            .description("Pacote Viagem + Certificado")
            .build();

    CandidateVacancy candidateVacancy1 = CandidateVacancy.builder()
            .description("Estou de férias do trabalho e gostaria de conhecer sua empresa")
            .startDate(new Date("15/03/2022"))
            .endDate(new Date("20/04/2022"))
            .situation('0')
            .user(user1)
            .hostingVacancy(hostingVacancy2).build();

    CandidateVacancy candidateVacancy2 = CandidateVacancy.builder()
            .description("Nunca conheci o nordeste do país, gostaria de começar por Pernambuco")
            .startDate(new Date("10/02/2022"))
            .endDate(new Date("12/03/2022"))
            .situation('0')
            .user(user2)
            .hostingVacancy(hostingVacancy1).build();

    CreditCardCredentials credentials = CreditCardCredentials.builder()
            .number("2569352698569847")
            .holder("Maria Joana da Silva")
            .dueDate(new Date("01/09/2030"))
            .cvv("123")
            .build();
}
