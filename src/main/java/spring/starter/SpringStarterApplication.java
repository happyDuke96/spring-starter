package spring.starter;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.starter.bfpp.LogBeanFactoryPostProcessor;
import spring.starter.bfpp.VerifyPropertyBeanFactoryPostProcessor;
import spring.starter.database.repository.CompanyRepository;
import spring.starter.database.pool.ConnectionPool;
import spring.starter.database.repository.CrudRepository;

public class SpringStarterApplication {

    public static void main(String[] args) {

        // IOC
//        var container = new Container();
//        var pool = container.get(ConnectionPool.class);
//        var userRepository = container.get(UserRepository.class);
//        var userService = container.get(UserService.class);



        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            // without ConnectionPool.class returned Object
            var connectionPool = context.getBean("pool1", ConnectionPool.class);  //Здесь может получить по индекс или по name

            System.out.println(connectionPool); // Здесь уже  можем  видеть установленный нам параметры в application yaml и другие

            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(2));


            System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(VerifyPropertyBeanFactoryPostProcessor.class));
            System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(LogBeanFactoryPostProcessor.class));

            /**
             * Spring поставляет properties(значение) с помощью BeanFactoryPostProcessor child -> (PropertyResourceConfigurer)
             * этот класс вызывает метод postProcessBeanFactory
             * который принимает ConfigurableListableBeanFactory --> он же BeanFactory --> ApplicationContext
             * в этом методе всегда создается новый MutablePropertySources класс потом берет environment дальше распарсить
             * prefix --> '${'   postfix --> '}' добавляет/обновляет  значение из environment
             */
        }
    }

}
