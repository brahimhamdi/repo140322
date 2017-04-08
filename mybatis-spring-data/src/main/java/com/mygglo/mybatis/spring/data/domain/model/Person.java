package com.mygglo.mybatis.spring.data.domain.model;

import lombok.Data;
import org.springframework.data.mybatis.annotations.Entity;
import org.springframework.data.mybatis.annotations.Id;
import org.springframework.data.mybatis.annotations.OneToMany;
import org.springframework.data.mybatis.domains.LongId;

import java.util.List;

@Data
@Entity
public class Person extends LongId{
 private String firstName;
 private String lastName;
 private String telephone;
 @OneToMany
 private List<Car> cars;
}
