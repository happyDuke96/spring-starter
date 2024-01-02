package spring.starter.integration;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import spring.starter.database.pool.ConnectionPool;

@TestConfiguration
public class TestSpringStarterApplication {

    @SpyBean
    private ConnectionPool pool1;
}
