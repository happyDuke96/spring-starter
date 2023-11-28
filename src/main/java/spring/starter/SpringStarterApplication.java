package spring.starter;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.starter.bfpp.LogBeanFactoryPostProcessor;
import spring.starter.bfpp.VerifyPropertyBeanFactoryPostProcessor;
import spring.starter.config.ApplicationConfiguration;
import spring.starter.database.pool.ConnectionPool;
import spring.starter.database.repository.CrudRepository;
import spring.starter.service.CompanyService;

public class SpringStarterApplication {

    public static void main(String[] args) {



        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            // without ConnectionPool.class returned Object
            var connectionPool = context.getBean("pool1", ConnectionPool.class);  //Здесь может получить по индекс или по name

            System.out.println(connectionPool); // Здесь уже  можем  видеть установленный нам параметры в application yaml и другие

            var companyService = context.getBean(CompanyService.class);
            System.out.println(companyService.findById(2));


            System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(VerifyPropertyBeanFactoryPostProcessor.class));
            System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(LogBeanFactoryPostProcessor.class));
        }
    }

}
