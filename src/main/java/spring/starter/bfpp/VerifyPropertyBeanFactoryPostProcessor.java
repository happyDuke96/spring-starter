package spring.starter.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

public class VerifyPropertyBeanFactoryPostProcessor implements BeanFactoryPostProcessor , Ordered {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Здесь создается сначала базовый BeanFactoryPostProcessor child -> (PropertyResourceConfigurer)" +
                "потому что по приоритету он выше ");
    }

    @Override
    public int getOrder() {
        System.out.println("Tут можно узнать приоритет бина чем меньше тем бин будет ближе/выше по приоритету ");
        return 0;
    }
}
