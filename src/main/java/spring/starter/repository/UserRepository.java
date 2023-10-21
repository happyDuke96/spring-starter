package spring.starter.repository;

import spring.starter.repository.pool.ConnectionPool;

public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
