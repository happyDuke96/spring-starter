package spring.starter.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.starter.database.pool.ConnectionPool;
import spring.starter.integration.annotation.IT;
import spring.starter.service.UserService;

/**
 * ApplicationContext создается два раза для UserServiceIT и для CompanyServiceIT
 * потомучто пропертей резные в CompanyServiceIT properties из test когда пропертей разные подмывается два раза сама приложение
 * что очень плохо когда проект большой. Обходный путь использовать один и тот же properties использовать @IT аннотацию и для UserServiceIT
 * еще есть случае два и более раза ApplicationContext поднимается,это когда создается @MockBean или @SpyBean
 * потому что для каждый интеграционный тест по умолчанию не может быть беаны моковым,но если мы хотим bean был mock или spy
 * для всех интеграционных тестов может указать конфигурациюи добавить в аннотацию @IT
 * туда ApplicationContext будет подниматься только один раз
 */
//@SpringBootTest
@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void findById() {

    }
}
