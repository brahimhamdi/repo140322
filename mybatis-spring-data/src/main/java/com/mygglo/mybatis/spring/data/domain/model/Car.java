package com.mygglo.mybatis.spring.data.domain.model;

import lombok.Data;
import org.springframework.data.mybatis.annotations.Entity;
import org.springframework.data.mybatis.annotations.OneToOne;
import org.springframework.data.mybatis.domains.LongId;

@Data
@Entity
public class Car extends LongId{
 private String model;
 private String color;
}
