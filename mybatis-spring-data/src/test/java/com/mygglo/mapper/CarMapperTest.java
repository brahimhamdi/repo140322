package com.mygglo.mapper;

import com.mygglo.mybatis.spring.data.domain.model.Car;
import com.mygglo.mybatis.spring.data.domain.repository.CarRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jgaglo on 01/04/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarMapperTest {
  @Autowired
  CarRepository carRepository;


  Long car1Id=0L,car2Id=0L;
  Car car1,car2;

  @Before
  public void setUp() throws Exception {

//    cars
    car1 = new Car();
    car1.setColor("Red");
    car1.setModel("BMW");

    car2 = new Car();
    car2.setColor("Blue");
    car2.setModel("Mustang");

  }

  @After
  public void tearDown() throws Exception {
    carRepository.delete(car1Id);
    carRepository.delete(car2Id);

  }

  @Test
  public void testInsert() throws Exception {
    carRepository.insert(car1);
    assertThat(car1.getId()).isNotNull();
    car1Id = car1.getId();
  }

  @Test
  public void testFindAll() throws Exception {
    carRepository.insert(car1);
    car1Id = car1.getId();
    carRepository.insert(car2);
    car2Id = car2.getId();

    List<Car> cars = carRepository.findAll();

    assertThat(cars).hasSize(2);
  }

  @Test
  public void testFindById() throws Exception {
    carRepository.insert(car1);
    car1Id = car1.getId();

    Car c = carRepository.findOne(car1Id);

    assertThat(c).isNotNull();
    assertThat(c).isEqualTo(car1);
  }

  @Test
  public void testDelete() throws Exception {
    carRepository.insert(car1);
    car1Id = car1.getId();

    carRepository.delete(car1Id);

    Car c = carRepository.findOne(car1Id);

    assertThat(c).isNull();
  }

  @Test
  public void testUpdate() throws Exception {
    carRepository.insert(car1);
    car1Id = car1.getId();

    car1.setColor("black");
    carRepository.update(car1);

    Car c = carRepository.findOne(car1Id);

    assertThat(c.getColor()).isEqualTo("black");

  }
}