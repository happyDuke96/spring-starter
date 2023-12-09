package spring.starter.database.pool;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool {


    @Value("${db.username}")
    private  final String username;

    @Value("${db.pool.size}")
    private  final Integer poolSize;


    @PostConstruct
    private void init() {
        log.info("Init Pool");
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
                '}';
    }
}
