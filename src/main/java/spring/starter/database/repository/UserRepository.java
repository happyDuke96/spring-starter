package spring.starter.database.repository;

import org.springframework.stereotype.Repository;
import spring.starter.database.pool.ConnectionPool;

@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
