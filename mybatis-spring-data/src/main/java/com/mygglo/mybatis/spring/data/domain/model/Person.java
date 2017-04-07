package com.mygglo.mybatis.spring.data.domain.model;

import lombok.Data;
import org.springframework.data.mybatis.annotations.Entity;

import java.util.List;

@Data
@Entity
public class Person{
 private Long id;
 private String firstName;
 private String lastName;
 private String telephone;
 private List<Car> cars;
}
