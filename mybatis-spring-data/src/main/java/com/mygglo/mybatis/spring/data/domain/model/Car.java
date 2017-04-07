package com.mygglo.mybatis.spring.data.domain.model;

import lombok.Data;
import org.springframework.data.mybatis.annotations.Entity;

@Data
@Entity
public class Car {
 private Long id;
 private String model;
 private String color;
 private Person person;
}
