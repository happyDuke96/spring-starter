package spring.starter.config.condition;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import spring.starter.config.DataBaseProperties;

import javax.annotation.PostConstruct;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {


    @Bean
    @ConfigurationProperties(prefix = "db")
    public DataBaseProperties dataBaseProperties(){
        return new DataBaseProperties();
    }
    @PostConstruct
    public void init(){
        System.out.println("Jpa config is enabled");
    }
}
