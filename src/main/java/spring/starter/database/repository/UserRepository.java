package spring.starter.database.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import spring.starter.database.pool.ConnectionPool;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(@Qualifier("pool2") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
