package spring.starter.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import spring.starter.config.DataBaseProperties;
import spring.starter.dto.CompanyReadDto;
import spring.starter.integration.annotation.IT;
import spring.starter.service.CompanyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT // объединили два аннотации @SpringBootTest & @ActiveProfiles("test")
@RequiredArgsConstructor
/* чтобы инжектить с помощью конструктора либо указать в spring.properties файле
 * @TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
* */
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DataBaseProperties dataBaseProperties;


    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult,actual));
    }
}
