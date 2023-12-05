package spring.starter.config.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {


    @PostConstruct
    public void init(){
        System.out.println("Jpa config is enabled");
    }
}
