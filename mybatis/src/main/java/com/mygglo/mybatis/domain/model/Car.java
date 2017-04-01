package com.mygglo.mybatis.domain.model;

import lombok.Data;

@Data
public class Car {
 private Long id;
 private String model;
 private String color;
 private Person person;
}
