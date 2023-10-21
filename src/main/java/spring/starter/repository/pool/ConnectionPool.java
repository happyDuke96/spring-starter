package spring.starter.repository.pool;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ConnectionPool {

    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private final Map<String,Object> properties;

    public ConnectionPool(String username,
                          Integer poolSize,
                          List<Object> args,
                          Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    private void init() {
        System.out.println("Init Pool");
    }

    private void destroy() { // this work after close
        System.out.println("Clear pool");
    }

    @Override
    public String toString() {
        return "ConnectionPool{" +
                "\nusername='" + username + '\'' +
                ",\n poolSize=" + poolSize +
                ",\n args=" + args +
                ",\n properties=" + properties +
                '}';
    }
}
