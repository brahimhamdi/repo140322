package com.mygglo.mybatis.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Person{
 private Long id;
 private String firstName;
 private String lastName;
 private String telephone;
 private List<Car> cars;
}
