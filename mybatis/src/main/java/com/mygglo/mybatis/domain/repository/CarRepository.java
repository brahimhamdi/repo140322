package com.mygglo.mybatis.domain.repository;

import com.mygglo.mybatis.domain.mapper.CarMapper;
import com.mygglo.mybatis.domain.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jgaglo on 01/04/17.
 */
@Repository
public class CarRepository {
  @Autowired
  CarMapper carMapper;

  public Car save(Car car){
    if (car.getId() == null){
      carMapper.insert(car);
    }else{
      carMapper.update(car);
    }

    return car;
  }

  public List<Car> findAll(){
    return carMapper.findAll();
  }


  public Car findById(Long id){
    return carMapper.findById(id);
  }

  public void delete(Long id){
    carMapper.delete(id);
  }

}
