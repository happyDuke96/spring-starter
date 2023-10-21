package spring.starter.bpp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Это аннотация чем-то похож на @Transactional
 * Для всех классов(Beans) помечен как @Transaction для всех методов этого класса будет открываться транзакция
 * и выполняется сам метод потом закрывается трназакция
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transaction {
}
