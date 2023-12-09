package spring.starter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import spring.starter.database.pool.ConnectionPool;
import spring.starter.database.repository.CrudRepository;
import spring.starter.database.repository.UserRepository;


//@ImportResource(locations = "classpath:application.xml")
@Import(WebConfiguration.class)
/** @Configuration - c этот аннотацию обрабатывает ConfigurationClassPostProcessor -> BeanFactoryPostProcessor
 * это значит он работает до создание бина в ConfigurationClassPostProcessor ConfigurationClassBeanDefinitionReader reader
 * который настроит бины до их создании */
@Configuration // proxyBeanMethods = false - for turnOff CGLIB
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = "spring.starter",
                resourcePattern = "**/*.class",
                useDefaultFilters = false,includeFilters = {
        @Filter(type = FilterType.ANNOTATION,value = Component.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE,value = CrudRepository.class),
        @Filter(type = FilterType.REGEX,pattern = "spring\\..+Repository")
})
public class ApplicationConfiguration {


    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON) // default
    public ConnectionPool pool2(@Value("${db.username}") String username,@Value("${db.pool.size}") Integer poolSize){
        return new ConnectionPool(username,20);
    }


    @Bean
    public ConnectionPool pool3(){
        return new ConnectionPool("test-username",31);
    }

    @Bean("beanUserRepository")
    public UserRepository userRepository(ConnectionPool pool2){
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository2(){
        /** по умолчанию Spring использует CGLIB proxy работает с наследованием с помощью класса ConfigurationClassEnhancer,
         * а это значит ApplicationConfiguration класс создает proxy для создание бинов
         *  соответственно pool3() вызывается только один раз для инициализации, */
        var connectionPool1 = pool3();
        var connectionPool2 = pool3();
        var connectionPool3 = pool3();
        return new UserRepository(pool3());
    }

    /** Spring Boot - это набор библиотек основана какого-то модуля спринга с автоконфигурацией,
     * с помощью аннотаций @Configuration(для создание разных бинов и его настройки) и @Conditional
     * для того включать или отключать то или иное конфигурации
     * */
}
