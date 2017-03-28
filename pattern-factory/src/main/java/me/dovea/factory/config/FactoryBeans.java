package me.dovea.factory.config;

import me.dovea.factory.factory.impl.Rectangle;
import me.dovea.factory.factory.ShapeFactory;
import me.dovea.factory.factory.impl.Circle;
import me.dovea.factory.factory.impl.Triangle;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"me.dovea.factory"})
public class FactoryBeans {
 @Bean
 public FactoryBean serviceLocatorFactoryBean() {
    ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(ShapeFactory.class);
    return factoryBean;
 }

 @Bean(name = "rectangle")
 @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public Rectangle rectangle() {
    return new Rectangle();
 }

 @Bean(name = "circle")
 @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public Circle circle() {
    return new Circle();
 }

 @Bean(name = "triangle")
 @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public Triangle triangle() {
    return new Triangle();
 }
}