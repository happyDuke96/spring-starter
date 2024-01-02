package spring.starter.integration.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.starter.SpringStarterApplication;
import spring.starter.config.DataBaseProperties;
import spring.starter.dto.CompanyReadDto;
import spring.starter.service.CompanyService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/** SpringExtension - класс помогает интегрироваться  с JUnit 5 моделями такие как
 * TestInstancePostProcessor,ParameterResolver,ExecutionCondition,TestExecutionExceptionHandler
 * и различные callback для взаимодействия во всех жизненный случае,он работает с
 * TestContext Framework - который создает TestContextManager для каждый тест классов отдельно
 * на основе ExtensionContext из JUnit 5 который содержит все метаданные о тестовых классах
 * TestContextManager есть два основные объекты,TestContext и TestExecutionListener
 * ***********************************************************************************************
 * проще говоря SpringExtension берет TestContextManager созданные с помощью TestContext Framework
 * TestContextManager проксирует JUnit 5 модели вышеуказанный и создает  свой собственный для интеграции с spring
 * */
/* @ExtendWith(SpringExtension.class)  для взаимодействия TestContext Framework с JUnit 5

 * @ContextConfiguration(classes = SpringStarterApplication.class) указать какой applicationContext будем использовать
 * в этом случае могут быть ошибка если мы создает bean на основе какой то application.properties а мы используем yaml формат
 * по умолчанию считывается из properties файла, @PropertySource,@TestPropertySource("classpath:application.yml")
 * тут не поможет потому что он считывает только properties файлы.
 * чтобы заработал и считывал с yaml файла можно добавить initializer @ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)


 * либо вообще использовать @SpringBootTest который содержит у себя
 * @ExtendWith(SpringExtension.class) и @ContextConfiguration(classes = SpringStarterApplication.class,initializers = ConfigDataApplicationContextInitializer.class)
 */
@SpringBootTest
@ActiveProfiles("test")
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private DataBaseProperties dataBaseProperties;


    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult,actual));
    }
}
