package spring.starter.database.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

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


    @PostConstruct
    private void init() {
        System.out.println("Init Pool");
    }

    /** @PostConstruct,@PreDestroy
     * С этим два аннотациями работает CommonAnnotationBeanPostProcessor
     * который реализует InitDestroyAnnotationBeanPostProcessor ...-> BeanPostProcessor
     * все BeanPostProcessor и их реализации работает до init() callbacks с помощью ApplicationContextAwareProcessor,
     * этот класс выставляет бинам дополнительный (значение,какой-то дополнительный бины(@see @InjectBean)) смотря какой AwareClass реализует
     *
     * ------------NOTE------------
     * BeanPostProcessor работает уже готовым бинами, a BeanFactoryPostProcessor работает до BeanPostProcessor
     * потому что BeanFactoryPostProcessor нужен для добавлений значение к BeanDefinition --> MetaData
     * после этого сортируется beans потом создается,далее можем с помощью BeanPostProcessor --> ApplicationContextAwareProcessor
     * настроить или инжектить другой beans  уже готовый beans
     * */
    @PreDestroy
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
