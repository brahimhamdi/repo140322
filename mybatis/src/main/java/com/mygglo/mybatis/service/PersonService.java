package com.mygglo.mybatis.service;

import com.mygglo.mybatis.domain.model.Car;
import com.mygglo.mybatis.domain.model.Person;
import com.mygglo.mybatis.domain.repository.CarRepository;
import com.mygglo.mybatis.domain.repository.PersonRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jgaglo on 04/04/17.
 */
@Service
public class PersonService {
  @Autowired
  PersonRepository personRepository;

  @Autowired
  CarRepository carRepository;

  public void populate(){
    Person person1 = new Person();
    person1.setFirstName(RandomStringUtils.randomAlphabetic(5));
    person1.setLastName(RandomStringUtils.randomAlphabetic(7));
    person1.setTelephone(RandomStringUtils.randomNumeric(7));

    Person person2 = new Person();
    person2.setFirstName(RandomStringUtils.randomAlphabetic(5));
    person2.setLastName(RandomStringUtils.randomAlphabetic(7));
    person2.setTelephone(RandomStringUtils.randomNumeric(7));

    personRepository.save(person1);
    personRepository.save(person2);


    Car car1 = new Car();
    car1.setColor("Red");
    car1.setModel("BMW");


    Car car2 = new Car();
    car2.setColor("Blue");
    car2.setModel("Mustang");

    carRepository.save(car1);
    carRepository.save(car2);
  }

  public List<Person> fetchAll(){
    return personRepository.findAll();
  }

  public void delete(Long id){
    personRepository.delete(id);
  }

  public Person findById(Long id){
    return personRepository.findById(id);
  }

  public Person save(Person person){
    return personRepository.save(person);
  }
}
