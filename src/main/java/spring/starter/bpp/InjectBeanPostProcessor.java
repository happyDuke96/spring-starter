package spring.starter.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;

public class InjectBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectBean.class)) // здесь берем только нужные который помечен с аннотацию InjectBean
                .forEach(field -> {
                            Object beanToInject = applicationContext.getBean(field.getType());
                            ReflectionUtils.makeAccessible(field);
                            ReflectionUtils.setField(field,bean,beanToInject);
                        });
        /**
         * после этого должны достать эти филды с помощью 'Aware' потому что у него будет доступ к ApplicationContext
         * это и есть IOC-Container по сути здесь может возвращать не сам bean а его Обертку(Proxy)
         * в документации написано что не надо так делать для этого предназначен другой метод postProcessAfterInitialization()
         **/
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}