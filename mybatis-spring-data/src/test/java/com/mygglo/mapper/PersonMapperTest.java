package com.mygglo.mapper;


import com.mygglo.mybatis.spring.data.domain.model.Car;
import com.mygglo.mybatis.spring.data.domain.model.Person;
import com.mygglo.mybatis.spring.data.domain.repository.CarRepository;
import com.mygglo.mybatis.spring.data.domain.repository.PersonRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by jgaglo on 01/04/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class PersonMapperTest {
  @Autowired
  PersonRepository personRepository;

  @Autowired
  CarRepository carRepository;


  Person person1,person2;
  Long person1Id=0L,person2Id=0L;

  Long car1Id=0L,car2Id=0L;
  Car car1,car2;

  @Before
  public void setUp() throws Exception {
//    Arrange
    person1 = new Person();
    person1.setFirstName("Toto");
    person1.setLastName("Nama");
    person1.setTelephone("77777777");

    person2 = new Person();
    person2.setFirstName("Bouki");
    person2.setLastName("Leuk");
    person2.setTelephone("8888888");


    //    cars
    car1 = new Car();
    car1.setColor("Red");
    car1.setModel("BMW");


    car2 = new Car();
    car2.setColor("Blue");
    car2.setModel("Mustang");

    person1.setCars(Arrays.asList(car1,car2));

  }

  @After
  public void tearDown() throws Exception {
    carRepository.delete(car1Id);
    carRepository.delete(car2Id);
    personRepository.delete(person1Id);
    personRepository.delete(person2Id);

  }

  @Test
  public void testInsert() throws Exception {

//    Act
    personRepository.insert(person1);

//    Assert
    assertThat(person1.getId()).isNotNull();

//    for  data cleaning purpose
    person1Id =person1.getId();
  }

  @Test
  public void testFindById() throws Exception {
//    Arrange
    personRepository.insert(person1);
    person1Id =person1.getId();


//    Act
    Person p = personRepository.findOne(person1Id);

//    Assert
    assertThat(p).isNotNull();
    assertThat(p).isEqualToIgnoringGivenFields(person1,"cars");
    assertThat(p.getCars()).hasSize(2);
    assertThat(p.getCars().get(0)).isEqualToIgnoringGivenFields(car1,"person");
    assertThat(p.getCars().get(1)).isEqualToIgnoringGivenFields(car2,"person");

  }

  @Test
  public void testSelectAll() throws Exception {
    //    Arrange
    personRepository.insert(person1);
    person1Id =person1.getId();

    personRepository.insert(person2);
    person2Id =person2.getId();

//    Act
    List<Person> persons = personRepository.findAll();

//    Assert
    assertThat(persons).isNotNull();
    assertThat(persons).hasSize(2);

  }

  @Test
  public void testUpdate() throws Exception {
//    Arrange
    personRepository.insert(person1);
    person1Id =person1.getId();

//    Act
    person1.setFirstName("TheOne");
    personRepository.update(person1);

//    Assert
    Person p = personRepository.findBasicOne(person1Id);

    assertThat(p.getFirstName()).isEqualTo("TheOne");


  }

  @Test
  public void testDelete() throws Exception {
    //    Arrange
    personRepository.insert(person1);
    person1Id =person1.getId();

//    Act
    personRepository.delete(person1Id);

//    Assert
    Person p = personRepository.findOne(person1Id);
    assertThat(p).isNull();

  }
}