package spring.starter.bpp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Чтобы инжектить ConnectionPool в CompanyRepository в кастомный BeanPostProcessor
 * альтернатива @Autowired
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectBean {


}
