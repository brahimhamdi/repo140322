package com.mygglo.batch.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jgaglo on 20/04/17.
 */
public class CarRowMapper implements RowMapper<Car> {
  @Override
  public Car mapRow(ResultSet resultSet, int i) throws SQLException {
    Car car = new Car();
    car.setId(resultSet.getLong("id"));
    car.setColor(resultSet.getString("color"));
    car.setModel(resultSet.getString("model"));
    return car;
  }
}
